# JavaSignInManager


JavaSignInManager 是一個簡單的 Java 程序，用於讀取 dbs 文件，檢查使用者登入並記錄最近的簽到時間。 此程式包含了一個使用者介面（UserPanel），使用者可以查看最近的簽到時間、顯示已簽到的使用者清單以及更改密碼。

## 使用方法

1. **編譯程式**：使用 Java 編譯器（例如，javac）編譯 Hw.java 檔案。

    ```bash
    javac JavaSignInManager.java
    ```

2. **執行程式**：執行編譯後的程序，並提供 dbs 檔案的路徑作為命令列參數。

    ```bash
    java Hw path/to/your/file.csv
    ```

3. **登入**：程式將開啟登入窗口，輸入正確的使用者名稱和密碼，點擊 "Login" 按鈕。

    ![image](https://github.com/BAGLE102/JavaSignInManager/assets/146699756/4dad16a4-a81e-47bb-a233-4359c24ab3de)


5. **查看最近簽到時間**：登入成功後，程式將顯示使用者的帳戶資訊和最近的簽到時間。

     ![image](https://github.com/BAGLE102/JavaSignInManager/assets/146699756/cc1bd067-2cba-4d91-b70c-e742ba99a42e)


7. **顯示已簽到使用者清單**：在使用者介面中，點選 "顯示已簽到的" 按鈕，以顯示已簽到使用者的清單。

8. **更改密碼**：在使用者介面中，點擊 "更改密碼" 按鈕，輸入新密碼並點擊 "OK"。

   ![image](https://github.com/BAGLE102/JavaSignInManager/assets/146699756/039db95b-2323-4769-8a80-172d5e564cee)


## 檔案格式

dbs 檔案應包含每行使用者的帳號和密碼，以空格分隔。
