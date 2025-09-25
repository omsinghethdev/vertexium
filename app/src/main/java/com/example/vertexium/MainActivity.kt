package com.example.vertexium

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputName: EditText
    private lateinit var inputDecision: EditText
    private lateinit var btnStoreOnChain: Button
    private lateinit var btnAddPerson: Button
    private lateinit var btnSubmitAll: Button
    private lateinit var tvStatus: TextView
    private lateinit var tvPersonList: TextView

    private val peopleList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(resources.getIdentifier("activity_main", "layout", packageName))

        // Views find karo
        inputName = findViewById(R.id.inputName)
        inputDecision = findViewById(R.id.inputDecision)
        btnStoreOnChain = findViewById(R.id.btnStoreOnChain)
        btnAddPerson = findViewById(R.id.btnAddPerson)
        btnSubmitAll = findViewById(R.id.btnSubmitAll)
        tvStatus = findViewById(R.id.tvStatus)
        tvPersonList = findViewById(R.id.tvPersonList)

        // Button clicks
        btnAddPerson.setOnClickListener { addPerson() }
        btnStoreOnChain.setOnClickListener { storeSingle() }
        btnSubmitAll.setOnClickListener { submitAll() }
    }

    private fun addPerson() {
        val name = inputName.text.toString().trim()
        val decision = inputDecision.text.toString().trim()

        if (name.isEmpty() || decision.isEmpty()) {
            tvStatus.text = "PLEASE FILL NAME AND DECISION BOTH."
            return
        }

        // Person add karo list mein
        val personData = "$name: $decision"
        peopleList.add(personData)

        // Input fields clear karo
        inputName.setText("")
        inputDecision.setText("")

        // List update karo
        updatePersonList()

        tvStatus.text = "$name add ho gaya! Total: ${peopleList.size}"
    }

    private fun updatePersonList() {
        if (peopleList.isEmpty()) {
            tvPersonList.text = "0 People Added."
            return
        }

        val listText = StringBuilder()
        for (i in peopleList.indices) {
            listText.append("${i + 1}. ${peopleList[i]}\n\n")
        }

        tvPersonList.text = listText.toString()
    }

    private fun storeSingle() {
        val name = inputName.text.toString().trim()
        val decision = inputDecision.text.toString().trim()

        if (name.isEmpty() || decision.isEmpty()) {
            tvStatus.text = "Fill Name and Decision both."
            return
        }

        tvStatus.text = "Storing $name on blockchain..."

        // Simulate blockchain call
        Thread {
            try {
                Thread.sleep(2000) // 2 second wait
                runOnUiThread {
                    tvStatus.text = " $name successfully stored on blockchain!"
                    inputName.setText("")
                    inputDecision.setText("")
                }
            } catch (e: InterruptedException) {
                runOnUiThread {
                    tvStatus.text = "❌ Error storing on blockchain"
                }
            }
        }.start()
    }

    private fun submitAll() {
        if (peopleList.isEmpty()) {
            tvStatus.text = "Add some People first!"
            return
        }

        tvStatus.text = "Submitting ${peopleList.size} people to blockchain..."

        // Simulate batch blockchain submission
        Thread {
            try {
                Thread.sleep(3000) // 3 second wait
                runOnUiThread {
                    tvStatus.text = "✅ Successfully stored ${peopleList.size} people on Aptos blockchain!"

                    // Clear list after successful submission
                    peopleList.clear()
                    updatePersonList()
                }
            } catch (e: InterruptedException) {
                runOnUiThread {
                    tvStatus.text = "❌ Error submitting to blockchain"
                }
            }
        }.start()
    }
}