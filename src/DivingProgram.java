/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Huige1
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class DivingProgram {
	public static Scanner input = new Scanner(System.in);
	public static final int JUDGE_SIZE=7;
	public static void main(String[]args){
	
		double[]diverScores = new double[JUDGE_SIZE];
		double Difficulty= 0, score= 0;
			
                     System.out.println( "DiverScoring \t\t\t Program");
			
			Difficulty= inputValidDegreeOfDifficulty();
			diverScores = inputAllScores();
			score = calculateScore(diverScores, Difficulty);
			Difficulty = Math.round(Difficulty* 100.0)/100.0;
			System.out.println( "Degree of Difficulty \t\t" +  Difficulty);
			for( int i=0; i<JUDGE_SIZE; i++){
				System.out.println("Judge Number:"+(i+1)+"\t\t\t"+"Score:"+diverScores[i]);
			}
                        DecimalFormat df = new DecimalFormat("##.##");
                        System.out.println( "Overall Score \t\t\t" + df.format(score));
			input.close();
	}

   
	
//to store scores entered by judges
	public static double inputValidScore(){
			double value=11;
			while (value<0 | value>10){
				System.out.println("Please enter a valid score between 0 and 10");
				value=input.nextDouble();
				if(value<0 | value>10)
					System.out.println("Invalid entry. Please try again.");
				else;
			}
			return value;
	}

	public static double[] inputAllScores(){
		double[] value = new double [JUDGE_SIZE];
 		
		int i= 0;
		while(i!=JUDGE_SIZE){
			value[i]=inputValidScore();
			i++;
		}
	return value;
	}
	
//to store difficulty
	public static double inputValidDegreeOfDifficulty(){
		double dif= 0.0;
		while(dif<1.2 | dif>3.8){
			System.out.println("Please enter a valid degree of difficulty between 1.2 and 3.8 for diver");
			dif= input.nextFloat();
			if(dif<1.2 | dif>3.8)
                            
				System.out.println("Invaild entry");
			else
				System.out.println("Thank you");
		}
		return dif;
	}
//Two Dimensional array to calculate the score 

	public static double calculateScore(double[] jScore, double dDif){
		double score =  0;
		int maxSc= 0, minSc= 0;
//to exclude max
		for (int i=0; i<JUDGE_SIZE; i++){
			if(jScore[i]>jScore[maxSc])
				maxSc=i;
		}	
//excluding min
		for (int i=0; i<JUDGE_SIZE; i++){
			 if(jScore[i]<jScore[minSc])
				minSc=i;
		}

		for(int i=0; i< JUDGE_SIZE; i++){
			score +=jScore[i];
		}
			score -=minSc+maxSc;
			score *=dDif*0.6; 
                        
                        
			return score;
	}

 
	
	
	
}

