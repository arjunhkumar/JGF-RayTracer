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
*                 Original version of this code by                        *
*            Florian Doyon (Florian.Doyon@sophia.inria.fr)                *
*              and  Wilfried Klauser (wklauser@acm.org)                   *
*                                                                         *
*      This version copyright (c) The University of Edinburgh, 2001.      *
*                         All rights reserved.                            *
*                                                                         *
**************************************************************************/


package raytracer; 


/**
 * This class reflects the 3d vectors used in 3d computations
 */
public primitive class Vec implements java.io.Serializable {

  /**
   * The x coordinate
   */
  public final double x; 

  /**
   * The y coordinate
   */
  public final double y;

  /**
   * The z coordinate
   */
  public final double z;
  
  public final boolean isNull;

  /**
   * Constructor
   * @param a the x coordinate
   * @param b the y coordinate
   * @param c the z coordinate
   */
  public Vec(double a, double b, double c) {
    x = a;
    y = b;
    z = c;
    isNull = false;
  }

  /**
   * Copy constructor
   */
  public Vec(Vec a) {
    x = a.x;
    y = a.y;
    z = a.z;
    isNull = false;
  }
  /**
   * Default (0,0,0) constructor
   */
  public Vec() {
    x = 0.0;
    y = 0.0; 
    z = 0.0;
    isNull = false;
  }

  /**
   * JGF Valhalla
   */
  public Vec(boolean isNull) {
	  this.x = 0.0;
	  this.y = 0.0; 
	  this.z = 0.0;
	  this.isNull = isNull;
  }
  
  /**
   * Add a vector to the current vector
   * @param: a The vector to be added
   */
//  public final void add(Vec a) {
//    x+=a.x;
//    y+=a.y;
//    z+=a.z;
//  }  

  /**
   * adds: Returns a new vector such as
   * new = sA + B
   */
  public static Vec adds(double s, Vec a, Vec b) {
    return new Vec(s * a.x + b.x, s * a.y + b.y, s * a.z + b.z);
  }
    
  /**
   * Modified method. JGF-Valhalla
   * Adds vector such as:
   * this+=sB
   * @param: s The multiplier
   * @param: b The vector to be added
   */
  public final Vec adds(double s,Vec b){
	 return new Vec(x+s*b.x,  y+s*b.y, z+s*b.z);
  }

  /**
   * Substracs two vectors
   */
  public static Vec sub(Vec a, Vec b) {
    return new Vec(a.x - b.x, a.y - b.y, a.z - b.z);
  }
  
  /**
   * JGF-Valhalla
   * Substracts two vects and places the results in the current vector
   * Used for speedup with local variables -there were too much Vec to be gc'ed
   * Consumes about 10 units, whether sub consumes nearly 999 units!! 
   * cf thinking in java p. 831,832
 * @return 
   */
  public final Vec sub2(Vec a,Vec b) {
	return new Vec(a.x-b.x,a.y-b.y,a.z-b.z);
  }

  public static Vec mult(Vec a, Vec b) {
    return new Vec(a.x * b.x, a.y * b.y, a.z * b.z);
  }

  public static Vec cross(Vec a, Vec b) {
    return
      new Vec(a.y*b.z - a.z*b.y,
	      a.z*b.x - a.x*b.z,
	      a.x*b.y - a.y*b.x);
  }

  public static double dot(Vec a, Vec b) {
    return a.x*b.x + a.y*b.y + a.z*b.z;
  }

  public static Vec comb(double a, Vec A, double b, Vec B) {
    return
      new Vec(a * A.x + b * B.x,
	      a * A.y + b * B.y,
	      a * A.z + b * B.z);
  }

  //JGF-Valhalla
//  public final void comb2(double a,Vec A,double b,Vec B) {
//    x=a * A.x + b * B.x;
//    y=a * A.y + b * B.y;
//    z=a * A.z + b * B.z;      
//  }

  // JGF-Valhalla
  public final Vec scale(double t) {
    return new Vec (x *t, y * t, z * t);
  }

  //JGF-Valhalla
  public final Vec negate() {
	  return new Vec (-x,-y,-z);
  }

  //JGF-Valhalla
  public final Vec normalize() {
    double len;
    len = Math.sqrt(x*x + y*y + z*z);
    if (len > 0.0) {
      return new Vec(x / len,y / len,z / len);
    }
    return new Vec(true);
  }

  public final String toString() {
    return "<" + x + "," + y + "," + z + ">";
  }
}
