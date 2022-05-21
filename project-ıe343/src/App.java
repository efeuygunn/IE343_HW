
	import java.lang.Math;
	import java.util.ArrayList;
	import java.util.Collections;

	import medianProblem.*;

	public class App {
		public static void main(String[] args){
	        Operators operator = new Operators();
	        double[][] facs_coordinates = operator.createDistanceMatrix(5,2);
	        double[][] points_coordinates = operator.createDistanceMatrix(20,2);
	        Facility[] facs = new Facility[5];
	        Point[] points = new Point [20];
	        for (int i=0; i<facs.length;i++){
	            Facility f1 = new Facility(i, facs_coordinates[i][0], facs_coordinates[i][1], 20*Math.random()+50);
	            facs[i] = f1;
	        }
	        for (int i=0; i<points.length;i++){
	            Point p1 = new Point (i, points_coordinates[i][0], points_coordinates[i][1], 2*Math.random()+1);
	            points[i] = p1;
	        }
	        double[][] distanceMatrix = operator.distanceMatrix(facs, points);
	        ArrayList<Facility> openedFacilities = new ArrayList<>();
	        ArrayList<Point> unassignedFacility = new ArrayList<>();
	        ArrayList<ArrayList<Point>> assignmentList = new ArrayList<>();
	     
	        ArrayList<Double> array_fac = new ArrayList<Double>(5);//I created this 5 elements array here since I want to update this array when I found the minimum distance in this array.
	     double totaldist=0;//This sum represents the total distance from customers to facilities
	        int size= array_fac.size();
	       while(openedFacilities.size()<=5)//I need to look at each facility until I reach p=5 facilities  {
	    	   if(openedFacilities.size()==0) {
	 for(int i=0;i<facs.length;i++) {
	 for(int j=0;j<points.length;j++) {//With using distfrom,I will make an enumeration and with this I ll find the shortest way and then,
		                               //I will extract the facility which has lowest distance.
		 totaldist+=operator.distFrom(i, j, i, j);
	    		   }
	 array_fac.add(totaldist);//I wrote here since we have 5 facilities.
	 //minimumu bul 5 tane içinden ve openedfacilitye en küçüðü ekle unassigned facilityden çýkar
	    		   }
	Collections.sort(array_fac);//I made a research about sorting the arrays then I found that I can use collections that's why I used it.
	//I sorted since right now I know first item of arraylist is the minimum one in an array.
	openedFacilities.add(array_fac.get(0));
	double min=Collections.min(array_fac);//I tried to add the minimum one in openedFacilities arraylist
	 unassignedFacility.remove(array_fac.get(min));
	    	   }
	    		   else {
	    			   for(int i=0;i< unassignedFacility.size();i++){
	    	    		   for(int j=0;j<points.length;j++) {
	    	    			   totaldist+=operator.distFrom(i, j, i, j);
	    	    		   }
	    	    		   array_fac.add(totaldist);
	    			   }
	    			   Collections.sort(array_fac);
	    			   openedFacilities.add(array_fac.get(0));
	    			   double min=Collections.min(array_fac);
	    			   unassignedFacility.remove(array_fac.get(min));
	    		   }
	    	   }

	}


