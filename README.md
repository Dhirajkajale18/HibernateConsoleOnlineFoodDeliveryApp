**🍔 Console Food App**
A simple Java console application demonstrating basic food ordering operations using JPA/Hibernate.
Users can view menus, register, place orders, view their orders, and cancel orders — all through a clean command-line interface!




**🚀 Features**
🍽️ View Menu: Browse available food items with prices

👤 User Registration: Register new users (basic info)

🛒 Place Order: Order food by selecting item and user ID

📋 View Orders: Check all orders for a user

❌ Cancel Order: Cancel orders by order ID


**

🛠️ Technologies Used**
Technology	Purpose
Java 17+	Core programming language
Jakarta Persistence	ORM with Hibernate
MySQL	Relational Database
Maven/Gradle	Dependency & build management
Console (Scanner)	User interaction input




**📁 Project Structure**
![image alt](C:\Users\Welcome\Pictures\Screenshots\Structure (2).png)








**⚙️ Setup Instructions**
1. Database Setup
Create a database called foodapp (or your preferred name).

Ensure tables for menu, orders, and users exist or let Hibernate create them.

2. Configure persistence.xml
Place the following config under src/main/resources/META-INF/persistence.xml:

xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence
                                 https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">

    <persistence-unit name="hibernaateConsoleFoodapp" transaction-type="RESOURCE_LOCAL">
        <class>Entity.usersEntity</class>
        <class>Entity.MenuEntity</class>
        <class>Entity.ordersEntity</class>

        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/foodapp"/>
            <property name="jakarta.persistence.jdbc.user" value="postgres"/>
            <property name="jakarta.persistence.jdbc.password" value="root123"/>

            <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="false"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>

