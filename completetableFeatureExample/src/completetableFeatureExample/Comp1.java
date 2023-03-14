package completetableFeatureExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Comp1 {
	Executor ex= Executors.newFixedThreadPool(5);
	 public  Void downloadWebPage(Integer nmb,List<Integer> ls1) throws InterruptedException, ExecutionException {
		 CompletableFuture<Void> c =CompletableFuture.runAsync(() -> {
	            // Code to download and return the web page's content
	            if (nmb == 1) {
	                System.out.println("***");
	            }
	            System.out.println("***" + nmb + Thread.currentThread().getName());
	            ls1.add(nmb);
	          

	        },ex);
		 return c.get();
		
	    }
	 // ek list with integer
	 // loop it 
	 // add each integer to any global list
	 // print result with time

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ls=IntStream.range(0, 100).boxed().collect(Collectors.toList());

		List<Integer> ls1=new ArrayList<>();
		Comp1 c= new Comp1();
	
		CompletableFuture completableFuture = new CompletableFuture();
		ls.stream()
				.forEach(webPageLink ->{
					try {
						c.downloadWebPage(webPageLink,ls1);
					} catch (InterruptedException | ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
//				map(webPageLink ->{
//					CompletableFuture<Integer> a=c.downloadWebPage(webPageLink,ls1);
//				
//					completableFuture.complete(a);
//					return a;
//				}).collect(Collectors.toList());
	//	completableFuture.complete(completableFuture);
				
//				
//				ls.stream()
//		        .forEach(webPageLink -> downloadWebPage(webPageLink,ls1))
//		       .collect(Collectors.toList());

//		CompletableFuture<Void> allFutures = CompletableFuture.allOf(
//				 pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()])
//		    //   System.out.println("**1*"+ pageContentFutures)); 
//		);  
//	
//		CompletableFuture<List<Integer>> allPageContentsFuture = allFutures.thenApply(v -> {
//			   return pageContentFutures.stream()
//			           .map(pageContentFuture -> {
//						try {
//							return pageContentFuture.get();
//						} catch (InterruptedException | ExecutionException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						return null;
//					})
//			           .collect(Collectors.toList());
//			});
		       // System.out.println(allFutures+"***"); 
		        System.out.println( "hhhhhh" +ls1); 
	}

}
