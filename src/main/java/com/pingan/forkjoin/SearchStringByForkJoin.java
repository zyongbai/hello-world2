package com.pingan.forkjoin;

import java.util.List;
import javafx.util.Pair;
import java.util.Optional;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.concurrent.Future;
import com.google.common.collect.Lists;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ExecutionException;

/**
 * ����Fork/Join�����ͳ��ĳ���ַ�����ĳ���ļ��е��ļ��г��ֵĴ���
 * �����㣺
 * 		JDK8��Stream
 * 		Lambda���ʽ
 * 		Fork/Join���
 * 
 * @author ZHANGYONG415
 *
 */
public class SearchStringByForkJoin extends RecursiveTask<List<Pair<String, Integer>>> {
	private static final long serialVersionUID = 1L;

	// ����ķ�ֵ
	private static final int THRESHOLD = 5;
	// ��������Ŀ�ʼֵ
	private int start;
	// ��������Ľ���ֵ
	private int end;
	// ���е�·����Ϣ
	private List<Path> allPaths;
	
	public SearchStringByForkJoin(int start, int end, List<Path> allPaths) {
		this.start = start;
		this.end = end;
		this.allPaths = allPaths;
	}
	
	@Override
	protected List<Pair<String, Integer>> compute() {
		List<Pair<String, Integer>> pairList = Lists.newArrayList();
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			pairList = IntStream.range(start, end + 1).mapToObj(i -> {
				if (i == allPaths.size()) {
					return new Pair<>("", 0);
				}
				int sum = 0;
				try {
					Optional optional = Files.lines(allPaths.get(i), Charset.forName("GBK")).map(file -> {
						int count = 0;
						int flag = file.indexOf("main");
						if (flag >= 0) {
							do {
								count++;
							} while ((flag = file.indexOf("main", flag + 1)) > 0);
						}
						return count;
					}).reduce(Integer :: sum);
					sum = optional.isPresent() ? (int) optional.get() : 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new Pair<>(allPaths.get(i).toString(), sum);
			}).collect(Collectors.toList());
		} else {
			// ȡ�м�ֵ
			int middle = (start + end) / 2;
			// ����Fork������
			SearchStringByForkJoin leftFork = new SearchStringByForkJoin(start, middle, allPaths);
			// ����Fork������
			SearchStringByForkJoin rightFork = new SearchStringByForkJoin(middle + 1, end, allPaths);
			// ִ��������
			leftFork.fork();
			rightFork.fork();
			
			// �ϲ�������Ľ����
			pairList.addAll(leftFork.join());
			pairList.addAll(rightFork.join());
		}
		return pairList;
	}
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		try {
			List<Path> pathList = Files.walk(Paths.get("D:\\Git\\zyong\\hello-world\\hello-world\\src\\main\\java\\com\\pingan\\forkjoin"), 4)
									   .filter(file -> !Files.isDirectory(file) && file.toString().endsWith("java"))
									   .collect(Collectors.toList());
			SearchStringByForkJoin searchStringByForkJoin = new SearchStringByForkJoin(0, pathList.size(), pathList);
			Future<List<Pair<String, Integer>>> result = forkJoinPool.submit(searchStringByForkJoin);
			List<Pair<String, Integer>> pairList = result.get();
			pairList.stream()
					.filter(pair -> pair.getValue() > 0)
					.sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
					.forEach(pair -> System.out.println(String.format("%d�γ�����%s�ļ���", pair.getValue(), pair.getKey().toString())));
			forkJoinPool.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
