package com.example.jnicalculator

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.jnicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mixedArray = arrayListOf<Int>()
    private var firstNumber: String = ""
    private var secondNumber: String = ""
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
    }

    private fun setListener() {
        binding.apply {
            mbtNumber0.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "0"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "0"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber1.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "1"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "1"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber2.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "2"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "2"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber3.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "3"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "3"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber4.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "4"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "4"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber5.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "5"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "5"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber6.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "6"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "6"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber7.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "7"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "7"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber8.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "8"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "8"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber9.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "8"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "9"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            btEquals.setOnClickListener {
                if (operation.isNotEmpty() && firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.GONE
                    binding.tvCalculateResult.visibility = View.VISIBLE
                    printOperationResult(operation)
                }
            }
            btClearAll.setOnClickListener {
                secondNumber = ""
                binding.tvSecondNumber.text = ""
                firstNumber = ""
                binding.tvFirstNumber.text = ""
                operation = ""
                binding.tvFirstNumber.visibility = View.VISIBLE
                binding.tvSecondNumber.visibility = View.VISIBLE
                binding.tvCalculateResult.visibility = View.GONE
            }
        }

        binding.apply {
            btAdd.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.ADD
                }
            }
            btMinus.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.MINUS
                }
            }
            btTimes.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.TIMES
                }
            }
            btDivision.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.DIVISION
                }
            }
            btPercentage.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.PERCENTAGE
                }
            }
            btExponentiation.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.EXPONENTIATION
                }
            }
        }
    }

    private external fun stringFromJNI(number: String): String

    private external fun calculateAdd(number: Int, operador: Int): Int

    private external fun calculateMinus(number: Int, operador: Int): Int

    private external fun calculateTimes(number: Int, operador: Int): Int

    private external fun calculateDivision(number: Int, operador: Int): Double

    private external fun calculateExponentiation(number: Int, operador: Int): Int

    private external fun calculatePercentage(number: Int, operador: Int): Double

    private external fun firstLogInCpp(text: String)

    private external fun concatenateNumbers(currentNumber: String, newDigit: String): String


    companion object {
        init {
            System.loadLibrary("jnicalculator")
        }
    }

    private fun printOperationResult(operation: String) {
        firstLogInCpp("Fazendo log!")
        val firstNumber = binding.tvFirstNumber.text.toString()
        val secondNumber = binding.tvSecondNumber.text.toString()
        if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
            val number = firstNumber.toInt()
            val operador = secondNumber.toInt()

            when (operation) {
                Constants.ADD -> binding.tvCalculateResult.text =
                    "${calculateAdd(number, operador)}"

                Constants.MINUS -> binding.tvCalculateResult.text =
                    "${calculateMinus(number, operador)}"

                Constants.TIMES -> binding.tvCalculateResult.text =
                    "${calculateTimes(number, operador)}"

                Constants.DIVISION -> binding.tvCalculateResult.text =
                    "${calculateDivision(number, operador)}"

                Constants.EXPONENTIATION -> binding.tvCalculateResult.text =
                    "${calculateExponentiation(number, operador)}"

                Constants.PERCENTAGE -> binding.tvCalculateResult.text =
                    "${calculatePercentage(number, operador)}"
            }
        }
    }
}