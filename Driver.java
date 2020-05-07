import java.util.Arrays;
import java.util.Random;

public class Driver
{
    public static void main(String[] args)
    {
        GameArena gameArena = new GameArena(2375, 1000);
     
        int numOfBalls=1000;
     
        Ball[] balls = new Ball[numOfBalls];
        double[] xSpeedArray = new double[numOfBalls];
        double[] ySpeedArray = new double[numOfBalls];
        String[] colours = new String[]{"BLACK", "BLUE", "CYAN", "DARKGREY", "GREY", "GREEN", "LIGHTGREY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE", "YELLOW"};

        double xStartPoint = (gameArena.getArenaWidth())/2;
        double yStartPoint = (gameArena.getArenaHeight())/2;

        Random rand = new Random();

        for(int i=0; i<numOfBalls; i++){
            double randOne = (Math.random()*((15-(-15))+1))-15;
            double randTwo = (Math.random()*((15-(-15))+1))-15;
            int picker = (int)(Math.random()*((12-0)+1));
            String randColour = colours[picker];
            balls[i]= new Ball(xStartPoint, yStartPoint, 50, randColour, randOne, randTwo);
            gameArena.addBall(balls[i]);
        }     

        double bounceHeight = 0;
        double fractionOfHeight = gameArena.getArenaHeight();

        double xSpeed=0;
        double ySpeed=0;

        for(int i=0; i<numOfBalls; i++){
            xSpeedArray[i]=balls[i].getXSpeed();
            ySpeedArray[i]=balls[i].getYSpeed();
        }

        while(true){
            
            for(int i=0; i<balls.length; i++){

                double x = balls[i].getXPosition();
                double y = balls[i].getYPosition();

                if(x>gameArena.getArenaWidth() || x<0){
                    xSpeedArray[i] = -(xSpeedArray[i]);
                }
                if(y>gameArena.getArenaHeight() || y<0){
                    ySpeedArray[i] = -(ySpeedArray[i]);
                }

                balls[i].setXPosition (x + xSpeedArray[i]);
                balls[i].setYPosition (y + ySpeedArray[i]);

                gameArena.pause();
            }

        }
    }
}