/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 *                          2013-02-10
 */
package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Rafel
 */
public class Hangman {
    
    //Vars
    private String word;
    private char currentStatus[];
    private int attempts = 10;
    private boolean alive = false;
    private ArrayList<String> guesses;
    private int score;
    
    //Konstruktur
    public Hangman(){
        this.guesses = new ArrayList<String>();
    }
    
    // Nyttspel
    public void newGame(){
        setRandomWord();
        resetAttempts();
        this.guesses.removeAll(guesses);
        this.alive = true;        
    }
    
    // Hämtar ett random ord från textfilen
    public String setRandomWord() {

        File file = new File("c:/words.txt");
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {
                contents.append(text).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        String[] temp;
        
        temp = contents.toString().split("\n");
        
        // Setting the seed
        Random randomGenerator = new Random();

        // Generating random number
        int randomInt = randomGenerator.nextInt(temp.length);

        // show file contents here
        String returnword = temp[randomInt];
        System.out.println(returnword);
        this.word = returnword;
        this.currentStatus = new char[this.word.length()];
        generateEmptyString(word);
        return returnword;

    }
    
    // Om klienten gissar på hela ordet
    public boolean  allIn(String guess){
        if(guess.equalsIgnoreCase(this.word)){
            return true;
        }
        else {
            attempts--;
            return false;
        }
    }
    
    // Mainfunktionen som alltid ska anropas med clientens gissning
    public String guessWord(String guess){
        if(guess.equalsIgnoreCase("NewGame")){
            newGame();
            return "GAME:" + new String(this.currentStatus);
        }
        if(!getGameStatus()){
            return "MESSAGE:Start Game First";
        }
        if(attemptsLeft()==0){
            this.alive = false;
            return "MESSAGE:Tyvärr du har torskat!";
        }
        if(ifUsed(guess)){
            return "MESSAGE:Ordet/Bokstaven är fel och använd!";
        }
        if(guess.length()==0)
            return "MESSAGE:Du måste minst ange en bokstav!";
        if(guess.length() > 1){
            if(allIn(guess)){
                this.alive = false;
                setScore();
                return "DONE:" + this.word;                
            }
            else {
                addWrong(guess);
                return "GAME:" + new String(this.currentStatus) + " Left attempts: " + attemptsLeft();             
            }
        }
        else {
            return guessChar(guess);
        }
        
    }
    
    // Kollar om bokstaven finns
    public String guessChar(String guess){
        if(this.word.contains(guess)){
            for (int i = 0; i < this.word.length(); i++) {
                if(guess.charAt(0)==this.word.charAt(i)){
                    this.currentStatus[i] = guess.charAt(0);
                }
            }
            String current = new String(this.currentStatus);
            if(!current.contains("-")){
                this.alive = false;
                setScore();
                return "DONE:" + this.word;
            }
            else {
            return "GAME:" + new String(this.currentStatus) + " Left attempts: " + attemptsLeft();
            }
            
        }
        else {
            attempts--;
            addWrong(guess);
            return "GAME:" + new String(this.currentStatus) + " Left attempts: " + attemptsLeft();
        }
    }
    
    // Skapar --- av abc
    public void generateEmptyString(String word){
        for (int i = 0; i < word.length(); i++) {
            this.currentStatus[i] = '-';
        }
        
    } 
    
    // Antar försök kvar
    public int attemptsLeft() {
        return this.attempts;
    }
    
    // Returnerar ordet
    public String getWord(){
        return this.word;
    }

    // Återställer antalet försök kvar
    public void resetAttempts() {
        this.attempts = 10;
    }
    
    // Om spelet är igång
    public boolean getGameStatus(){
        return this.alive;
    }

    // Lägger till fel ord/bokstav i listan
    public void addWrong(String guess){
        guesses.add(guess);
    }
    
    // Om ordet/bokstaven är redan gissad
    public boolean ifUsed(String guess){
        boolean resultat = false;
        for (int i = 0; i < guesses.size(); i++) {
            
            if(guess.equals(guesses.get(i)))
                return true;
        }
        return resultat;
    }
    
    // Returnerar poäng
    public int getScore(){
        return this.score;
    }

    // Returnerar alla fel försöken
    String getWrongWords() {
        StringBuilder sb = new StringBuilder();
        sb.append("ATTEMPTS:");
        if(!guesses.isEmpty()){        
            for (int i = 0; i < guesses.size(); i++) {   
                sb.append(guesses.get(i)).append(",");
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    
    // Sätter poäng
    private void setScore(){
        this.score += this.attempts*10;
    }
}
