package com.example.tictactoeunlimited

import android.widget.Button

class ComputerLogic(countPlayerOne: MutableList<Button>,countPlayerTwo: MutableList<Button>, gameBoard: Array<Array<Button?>>) {

    private val playerOne = countPlayerOne
    private val playerTwo = countPlayerTwo
    private val gameBoardCheck = gameBoard

    fun checkTurn(): Button? {
        return if (playerOne.size == 1){
            turnOne()
        } else{
            turnTwo(playerTwo)
        }
    }

    private fun turnOne(): Button? {
        return if (playerOne.contains(gameBoardCheck[0][0])
            || playerOne.contains(gameBoardCheck[0][1])
            || playerOne.contains(gameBoardCheck[0][2])){
            gameBoardCheck[1][1]
        } else if (playerOne.contains(gameBoardCheck[1][0])
            || playerOne.contains(gameBoardCheck[1][1])
            || playerOne.contains(gameBoardCheck[1][2])){
            gameBoardCheck[2][0]
        } else{
            gameBoardCheck[0][2]
        }
    }

    private fun turnTwo(player: MutableList<Button>): Button? {
        if (gameBoardCheck[0][2]?.text == "" &&
            (player.contains(gameBoardCheck[0][0]) && player.contains(gameBoardCheck[0][1])
            || player.contains(gameBoardCheck[2][0]) && player.contains(gameBoardCheck[1][1])
            || player.contains(gameBoardCheck[1][2]) && player.contains(gameBoardCheck[2][2]))){
                return gameBoardCheck[0][2]
        } else if (gameBoardCheck[0][1]?.text == "" &&
            (player.contains(gameBoardCheck[0][0]) && player.contains(gameBoardCheck[0][2])
            || player.contains(gameBoardCheck[1][1]) && player.contains(gameBoardCheck[2][1]))){
                return gameBoardCheck[0][1]
        } else if (gameBoardCheck[0][0]?.text == "" &&
            (player.contains(gameBoardCheck[0][1]) && player.contains(gameBoardCheck[0][2])
            || player.contains(gameBoardCheck[1][0]) && player.contains(gameBoardCheck[2][0])
            || player.contains(gameBoardCheck[1][1]) && player.contains(gameBoardCheck[2][2]))) {
                return gameBoardCheck[0][0]
        } else if (gameBoardCheck[1][0]?.text == "" &&
            (player.contains(gameBoardCheck[1][1]) && player.contains(gameBoardCheck[1][2])
            || player.contains(gameBoardCheck[0][0]) && player.contains(gameBoardCheck[2][0]))) {
                return gameBoardCheck[1][0]
        } else if (gameBoardCheck[1][1]?.text == "" &&
            (player.contains(gameBoardCheck[0][0]) && player.contains(gameBoardCheck[2][2])
            || player.contains(gameBoardCheck[0][2]) && player.contains(gameBoardCheck[2][0])
            || player.contains(gameBoardCheck[1][0]) && player.contains(gameBoardCheck[1][2])
            || player.contains(gameBoardCheck[0][1]) && player.contains(gameBoardCheck[2][1]))) {
                return gameBoardCheck[1][1]
        }  else if (gameBoardCheck[1][2]?.text == "" &&
            (player.contains(gameBoardCheck[0][2]) && player.contains(gameBoardCheck[2][2])
            || player.contains(gameBoardCheck[1][0]) && player.contains(gameBoardCheck[1][1]))) {
                return gameBoardCheck[1][2]
        } else if (gameBoardCheck[2][0]?.text == "" &&
            (player.contains(gameBoardCheck[1][1]) && player.contains(gameBoardCheck[0][2])
            || player.contains(gameBoardCheck[0][0]) && player.contains(gameBoardCheck[1][0])
            || player.contains(gameBoardCheck[2][1]) && player.contains(gameBoardCheck[2][2]))) {
                return gameBoardCheck[2][0]
        } else if (gameBoardCheck[2][2]?.text == "" &&
            (player.contains(gameBoardCheck[0][0]) && player.contains(gameBoardCheck[1][1])
            || player.contains(gameBoardCheck[0][2]) && player.contains(gameBoardCheck[1][2])
            || player.contains(gameBoardCheck[2][0]) && player.contains(gameBoardCheck[2][1]))) {
                return gameBoardCheck[2][2]
        } else if (gameBoardCheck[2][1]?.text == "" &&
            (player.contains(gameBoardCheck[0][1]) && player.contains(gameBoardCheck[1][1])
            || player.contains(gameBoardCheck[2][0]) && player.contains(gameBoardCheck[2][2]))) {
                return gameBoardCheck[2][1]
        } else if(player == playerTwo){
            return turnTwo(playerOne)
            } else {
            return if (gameBoardCheck[1][1]?.text == ""){
                gameBoardCheck[1][1]
            } else if (gameBoardCheck[0][2]?.text == ""){
                gameBoardCheck[0][2]
            } else if (gameBoardCheck[0][0]?.text == ""){
                gameBoardCheck[0][0]
            } else if (gameBoardCheck[2][2]?.text == ""){
                gameBoardCheck[2][2]
            } else{
                gameBoardCheck[2][0]
            }
        }
    }


}