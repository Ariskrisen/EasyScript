# EasyScript 🚀

**EasyScript** is a lightweight, high-performance scripting engine for Paper 1.21+, designed as a modern and flexible alternative to the classic Skript plugin. Instead of a custom syntax, it uses standard **JavaScript (via GraalVM)**, allowing you to leverage full programming power with direct access to the Bukkit/Paper API.

## ✨ Features

- **Modern JavaScript**: Write logic using JS (ES6+) with full access to Java classes and Bukkit API.
- **PlaceholderAPI Integration**: Built-in support for PAPI placeholders.
- **Dynamic Commands**: Register custom commands directly in your scripts.
- **Comprehensive Event API**: Listen to any Bukkit event with ease.
- **Built-in Scheduler**: Simplified sync/async/delayed task management.
- **Hot Reloading**: Change scripts and apply updates instantly with `/es reload`.
- **Lightweight & Fast**: Minimal overhead compared to complex scripting languages.

## 🛠️ Installation

1. Download the latest `EasyScript.jar`.
2. Place it in your server's `plugins` folder.
3. (Optional) Ensure **PlaceholderAPI** and **Vault** are installed for full feature support.
4. Restart your server.
5. Create your `.js` scripts in `plugins/EasyScript/scripts/`.

## 📜 Scripting Guide

### Basic Structure
Scripts are placed in `plugins/EasyScript/scripts/`. Each file is isolated and executed in its own context.

#### Handling Events
```javascript
const PlayerJoinEvent = Java.type('org.bukkit.event.player.PlayerJoinEvent');

events.on(PlayerJoinEvent, (event) => {
    const player = event.getPlayer();
    player.sendMessage("§aWelcome to the server!");
});
```

#### Registering Commands
```javascript
commands.register("hello", "Greating command", "/hello", (sender, args) => {
    sender.sendMessage("§bHello from EasyScript!");
});
```

#### Using Placeholders
```javascript
const msg = placeholder.setPlaceholders(player, "Your balance: %vault_eco_balance%");
player.sendMessage(msg);
```

#### Using the Scheduler
```javascript
scheduler.runLater(200, () => { // 10 seconds later
    player.sendMessage("This message appeared after a delay!");
});
```

## 🎮 Built-in Example: World Border Upgrade
EasyScript comes with a pre-installed `border_logic.js` which implements:
- Detecting first-time `/ws home` use.
- A 10-second notification delay.
- A 6-level world border upgrade system using `/upgrade-border`.
- Persistence using `player_data.json`.

## 💻 Commands
- `/easyscript reload` (Alias: `/es reload`) - Reloads all scripts from the `scripts/` folder.
- `/upgrade-border` - Example command from the default script.

## 🏗️ Development

### Prerequisites
- JDK 21
- Maven

### Build
```bash
mvn clean package
```
The output JAR will be in the `target/` directory (use the `-shaded.jar` for deployment).

## 📄 License
MIT License. Feel free to use and modify!
