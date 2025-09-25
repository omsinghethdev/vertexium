# 📝 Aptos Blockchain Notes App

An Android app (Kotlin) to **collect user decisions/wills and store them on the Aptos blockchain**.  
It supports adding multiple people, submitting all records to the chain, and viewing submitted records.

---

## ✨ Features
- Add multiple **Name + Important Decision** entries.
- Store a **single entry** or **submit all entries** to the blockchain.
- View all submitted blockchain records inside the app.
- Simple, scrollable UI with status updates.

---

## 🏗 Project Structure

---

## 🖼 UI Overview
The `activity_main.xml` contains:
- **EditText** for user name (`inputName`)
- **EditText** for decision (`inputDecision`)
- Buttons:
  - `btnAddPerson` – Add to local list
  - `btnStoreOnChain` – Store single record to blockchain
  - `btnSubmitAll` – Store all records
  - `btnViewRecords` – View all blockchain submissions
- TextViews:
  - `tvPersonList` – Show people added locally
  - `tvSubmittedRecords` – Show on-chain data
  - `tvStatus` – Status messages

---



# vertexium
