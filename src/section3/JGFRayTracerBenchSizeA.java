/**************************************************************************
*                                                                         *
*         Java Grande Forum Benchmark Suite - Thread Version 1.0          *
*                                                                         *
*                            produced by                                  *
*                                                                         *
*                  Java Grande Benchmarking Project                       *
*                                                                         *
*                                at                                       *
*                                                                         *
*                Edinburgh Parallel Computing Centre                      *
*                                                                         * 
*                email: epcc-javagrande@epcc.ed.ac.uk                     *
*                                                                         *
*                                                                         *
*      This version copyright (c) The University of Edinburgh, 2001.      *
*                         All rights reserved.                            *
*                                                                         *
**************************************************************************/


import raytracer.*;
import jgfutil.*;

public class JGFRayTracerBenchSizeA{ 

  public static int nthreads;

  public static void main(String argv[]){

  if(argv.length != 0 ) {
    nthreads = Integer.parseInt(argv[0]);
  } else {
    System.out.println("The no of threads has not been specified, defaulting to 1");
    System.out.println("  ");
    nthreads = 1;
  }

    JGFInstrumentor.printHeader(3,0,nthreads);
    JGFInstrumentor.addTimer("Section3:RayTracer:Total", "Solutions",0);
    JGFInstrumentor.addTimer("Section3:RayTracer:Init", "Objects",0);
    JGFInstrumentor.addTimer("Section3:RayTracer:Run", "Pixels",0);
    for(int i=0;i<100;i++) {
    	JGFRayTracerBench rtb = new JGFRayTracerBench(nthreads); 
        rtb.JGFrun(0);
        JGFInstrumentor.resetTimer("Section3:RayTracer:Total");
        JGFInstrumentor.resetTimer("Section3:RayTracer:Init");
        JGFInstrumentor.resetTimer("Section3:RayTracer:Run");
    }
  }
}


