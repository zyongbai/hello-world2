package com.pingan.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 使用串行以及并行(fork&join)的方式做累加运算
 * 
 * @author ZHANGYONG415
 *
 */
public class ForkJoinComputeSum extends RecursiveTask<Long> {
	private static final long serialVersionUID = 1L;
	
	private static final long MAX = 1000000000L;
	private static final long THRESHOLD = 10000L;
	
	private long start;
	private long end;
	
	public ForkJoinComputeSum(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long sum = 0;
		if (end - start <= THRESHOLD) {
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		} else {
			long mid = (start + end) / 2;
			
			ForkJoinComputeSum task1 = new ForkJoinComputeSum(start, mid);
			task1.fork();
			
			ForkJoinComputeSum task2 = new ForkJoinComputeSum(mid + 1, end);
			task2.fork();
			
			return task1.join() + task2.join();
		}
	}
	
	private static void test() {
		System.out.println("test");
		long start = System.currentTimeMillis();
		Long sum = 0L;
		for (long i = 0L; i <= MAX; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println((System.currentTimeMillis() - start) + "ms");
	}
	
	private static void testForkJoin() {
		System.out.println("testForkJoin");
		long start = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Long sum = forkJoinPool.invoke(new ForkJoinComputeSum(1, MAX));
		System.out.println(sum);
		System.out.println((System.currentTimeMillis() - start) + "ms");
	}
	
	public static void main(String[] args) {
		test();
		System.out.println("--------------------------------------");
		testForkJoin();
	}

}
