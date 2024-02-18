import javax.swing.JOptionPane;
public class GuessingGame {
    public static void main(String[] args) {
        int min = 1,max = 100,randomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min),attempts = 5,score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            for (int i = 1; i <= attempts; i++) {
                String guessString = JOptionPane.showInputDialog(null, "Guess a number between " + min + " and " + max + ". You have " + (attempts - i + 1) + " attempts left.");
                int guess = Integer.parseInt(guessString);
                
                if (guess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + i + " attempts.");
                    score++;
                    break;
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low. Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high. Try again.");
                }
                
                if (i == attempts) {
                    JOptionPane.showMessageDialog(null, "Sorry, you ran out of attempts. The number was " + randomNumber + ".");
                }
            }
            
            int playAgainOption = JOptionPane.showConfirmDialog(null, "Your score is " + score + ". Do you want to play again?");
            
            if (playAgainOption == JOptionPane.YES_OPTION) {
                randomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
            } else {
                playAgain = false;
            }
        }
    }
}
