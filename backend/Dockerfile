# 使用 Java 24 的官方映像檔
FROM eclipse-temurin:24-jdk

# 設定工作目錄
WORKDIR /app

# 複製所有檔案進容器
COPY . .

# 使用 Maven Wrapper 進行 build，並跳過測試
RUN ./mvnw clean package -DskipTests

# 執行 jar（請根據實際 jar 名稱調整）
CMD ["java", "-jar", "target/msg-board-0.0.1-SNAPSHOT.jar"]
