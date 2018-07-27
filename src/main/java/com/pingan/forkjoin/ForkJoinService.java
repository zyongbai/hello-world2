package com.pingan.forkjoin;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ExecutionException;

/**
 * 使用fork&join搜索集合中包含a的字符串
 * 
 * @author ZHANGYONG415
 *
 */
public class ForkJoinService extends RecursiveTask<List<String>> {
	private static final long serialVersionUID = 1L;
	
	private int threshold;// 阀值
	private List<String> list;// 待拆分
	
	public ForkJoinService(List<String> list, int threshold) {
		this.list = list;
		this.threshold = threshold;
	}
	
	@Override
	protected List<String> compute() {
		if (list.size() < threshold) {
			return list.parallelStream().filter((String s) -> s.contains("a"))
										.collect(Collectors.toList());
		} else {
			int middle = list.size() / 2;
			List<String> leftList = list.subList(0, middle);
			List<String> rightList = list.subList(middle, list.size());
			
			ForkJoinService left = new ForkJoinService(leftList, threshold);
			ForkJoinService right = new ForkJoinService(rightList, threshold);
			
			left.fork();
			right.fork();
			
			List<String> join = left.join();
			join.addAll(right.join());
			
			return join;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String[] strings = {"a", "ah", "b", "ba", "ab", "c"};
		List<String> stringList = new ArrayList<String>(Arrays.asList(strings));
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinService service = new ForkJoinService(stringList, 20);
		ForkJoinTask<List<String>> future = pool.submit(service);
		System.out.println(future.get());
		
		pool.shutdown();
		
	}
	
}
