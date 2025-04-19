/** Main.java
 * Raghav Bharath
 * Professor Kapleau
 * CS114 H02
 * Project 1 - Maze
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RecursiveMazeSolver {
    private static String[][] maze = new String[0][0];
    private static int X_curr, Y_curr, X_end, Y_end;
    private static String currRoute = "", correctRoute = "";

     
    public static void main(String[] args) {
        getMaze("../test/maze.dat.txt");
        solveMaze();
        findMaze();
    }

    
    private static void getMaze(String datMaze)
    {
        try (Scanner sc = new Scanner(new File(datMaze))){
            String str = sc.nextLine();
            int row = Integer.parseInt(str.split(" ")[0]);
            int col = Integer.parseInt(str.split(" ")[1]);
            
            maze = new String[row][col];
            for(int r = 0; r < maze.length; r++){
                str = sc.nextLine();
                for(int c = 0; c < maze[r].length; c++){
                    maze[r][c] = str.substring(c,c+1);
                }
            }

        } catch(FileNotFoundException e){
            System.out.println("Your file \"" + datMaze + "\" cannot be found");
            System.exit(0);
        }


        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze[r].length; c++){
                if(maze[r][c].equals("+")){ 
                    X_curr = c;
                    Y_curr = r;
                }

                if(maze[r][c].equals("-")){ 
                    X_end = c;
                    Y_end = r;
                }
            }
        }
    }

    private static void findMaze(){
        for(String[] row : maze){
            for(String x : row)
                System.out.print(x);

            System.out.println();
        }
    }

    private static void solveMaze()
    {
        if(X_curr == X_end && Y_curr == Y_end){
            System.out.println("The Maze has been solved!");
        }

        else if(test("right") || test("left") || test("down") || test("up")){

            if(test("right")){ 
                X_curr++;
                currRoute += "r";
            }

            else if(test("down")){ 
                Y_curr++;
                currRoute += "d";
            }

            else if(test("left")){ 
                X_curr--;
                currRoute += "l";
            }
            
            else{ 
                Y_curr--;
                currRoute += "u";
            }

            
            maze[Y_curr][X_curr] = "+";
            correctRoute = currRoute;
            solveMaze();
        }
        
        
        else{
            try{
                
                maze[Y_curr][X_curr] = ".";

                
                if(currRoute.charAt(currRoute.length()-1) == 'r') 
                    X_curr--;

                else if(currRoute.charAt(currRoute.length()-1) == 'd') 
                    Y_curr--;

                else if(currRoute.charAt(currRoute.length()-1) == 'l') 
                    X_curr++;

                else 
                    Y_curr++;

                       
                currRoute = currRoute.substring(0, currRoute.length()-1);
                solveMaze();
            }

            
            catch(StringIndexOutOfBoundsException e){
                System.out.println("Your maze cannot be solved."); 
                System.exit(0);
            }
        }
    }

    private static boolean test(String x){
        if(x.equals("right")) 
            return X_curr + 1 < maze[Y_curr].length && (maze[Y_curr][X_curr + 1].equals(" ") || maze[Y_curr][X_curr+1].equals("-"));

        else if(x.equals("down"))
            return Y_curr + 1 < maze.length && (maze[Y_curr+1][X_curr].equals(" ") || maze[Y_curr+1][X_curr].equals("-")); 

        else if(x.equals("left")) 
            return X_curr - 1 > 0 && (maze[Y_curr][X_curr - 1].equals(" ") || maze[Y_curr][X_curr - 1].equals("-"));
            
        else 
            return Y_curr - 1 > 0 && (maze[Y_curr - 1][X_curr].equals(" ") || maze[Y_curr - 1][X_curr].equals("-"));
    }
}