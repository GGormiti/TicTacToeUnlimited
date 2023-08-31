package com.example.tictactoeunlimited

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.tictactoeunlimited.databinding.FragmentGameWithFriendBinding

class GameWithFriendFragment : Fragment() {

    private var _binding: FragmentGameWithFriendBinding? = null
    private val binding get() = _binding!!
    private val bundle = Bundle()
    private var tagGame: String = "0"


    private val gameBoard = Array(size = 3){ arrayOfNulls<Button>(size = 3) }
    private val countPlayerOne = mutableListOf<Button>()
    private val countPlayerTwo = mutableListOf<Button>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameWithFriendBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tagGame = arguments?.getString("TagGame").toString()

        loadGameBoard()
        turnPlayerOne()
        binding.endButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameWithFriendFragment_to_startFragment)
        }
    }

    private fun loadGameBoard(){
        gameBoard[0][0] = binding.btn1
        gameBoard[0][0]?.text =""
        gameBoard[0][1] = binding.btn2
        gameBoard[0][1]?.text =""
        gameBoard[0][2] = binding.btn3
        gameBoard[0][2]?.text =""
        gameBoard[1][0] = binding.btn4
        gameBoard[1][0]?.text =""
        gameBoard[1][1] = binding.btn5
        gameBoard[1][1]?.text =""
        gameBoard[1][2] = binding.btn6
        gameBoard[1][2]?.text =""
        gameBoard[2][0] = binding.btn7
        gameBoard[2][0]?.text =""
        gameBoard[2][1] = binding.btn8
        gameBoard[2][1]?.text =""
        gameBoard[2][2] = binding.btn9
        gameBoard[2][2]?.text =""
    }

    @SuppressLint("SetTextI18n")
    private fun turnPlayerOne(){
        binding.textTurn.text = "Turn Player 1"
        for (i in gameBoard.indices) {
            for (j in gameBoard.indices) {
                if (gameBoard[i][j]?.isClickable == true){
                    gameBoard[i][j]?.setOnClickListener{
                        gameBoard[i][j]?.text = "X"
                        gameBoard[i][j]?.isClickable = false
                        gameBoard[i][j]?.let { it1 -> countPlayerOne.add(it1) }
                        if(countPlayerOne.size == 5){
                            bundle.putString("Winner", "Draw")
                            bundle.putString("TagGame", tagGame)
                            it.findNavController().navigate(R.id.action_gameWithFriendFragment_to_resultFragment, bundle)
                        } else if (checkWinners(countPlayerOne)){
                            bundle.putString("Winner", "Player 1 win")
                            bundle.putString("TagGame", tagGame)
                            it.findNavController().navigate(R.id.action_gameWithFriendFragment_to_resultFragment, bundle)
                        }
                        else{
                            if (tagGame == "0"){
                                turnPlayerTwo()
                            } else {
                                computerTurn()
                            }
                        }
                    }
                }

            }
        }
    }
    @SuppressLint("SetTextI18n")
    private fun turnPlayerTwo(){
        binding.textTurn.text = "Turn Player 2"
        for (i in gameBoard.indices) {
            for (j in gameBoard.indices) {
                gameBoard[i][j]?.setOnClickListener{
                    gameBoard[i][j]?.text = "O"
                    gameBoard[i][j]?.isClickable = false
                    gameBoard[i][j]?.let { it1 -> countPlayerTwo.add(it1) }
                    if (checkWinners(countPlayerTwo)){
                        bundle.putString("Winner", "Player 2 win")
                        bundle.putString("TagGame", tagGame)
                        it.findNavController().navigate(R.id.action_gameWithFriendFragment_to_resultFragment, bundle)
                    }
                    else{
                        turnPlayerOne()
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun computerTurn() {
        binding.textTurn.text = "Turn Computer"
        val computerTurn = ComputerLogic(countPlayerOne, countPlayerTwo, gameBoard).checkTurn()
        computerTurn?.let { it1 -> countPlayerTwo.add(it1) }
        computerTurn?.isClickable = false
        computerTurn?.text = "0"

        if (checkWinners(countPlayerTwo)){
            bundle.putString("Winner", "Computer win")
            bundle.putString("TagGame", tagGame)
            fragmentNavigation()
        }
        else{
            turnPlayerOne()
        }
    }

    private fun checkWinners(countWinner: List<Button>): Boolean{
        if (countWinner.contains(gameBoard[0][0]) && countWinner.contains(gameBoard[0][1]) &&
            countWinner.contains(gameBoard[0][2])){
            return true
        } else if(countWinner.contains(gameBoard[1][0]) && countWinner.contains(gameBoard[1][1]) &&
            countWinner.contains(gameBoard[1][2])){
            return true
        } else if(countWinner.contains(gameBoard[2][0]) && countWinner.contains(gameBoard[2][1]) &&
            countWinner.contains(gameBoard[2][2])){
            return true
        } else if(countWinner.contains(gameBoard[0][0]) && countWinner.contains(gameBoard[1][0]) &&
            countWinner.contains(gameBoard[2][0])){
            return true
        } else if(countWinner.contains(gameBoard[0][1]) && countWinner.contains(gameBoard[1][1]) &&
            countWinner.contains(gameBoard[2][1])){
            return true
        } else if(countWinner.contains(gameBoard[0][2]) && countWinner.contains(gameBoard[1][2]) &&
            countWinner.contains(gameBoard[2][2])){
            return true
        } else if(countWinner.contains(gameBoard[0][0]) && countWinner.contains(gameBoard[1][1]) &&
            countWinner.contains(gameBoard[2][2])){
            return true
        } else if(countWinner.contains(gameBoard[2][0]) && countWinner.contains(gameBoard[1][1]) &&
            countWinner.contains(gameBoard[0][2])){
            return true
        } else {
            return false
        }
    }

    private fun fragmentNavigation(){
            view?.let { Navigation.findNavController(it).navigate(R.id.action_gameWithFriendFragment_to_resultFragment, bundle) }
    }

}