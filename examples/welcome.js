// Example EasyScript for Paper 1.21.4
// Path: plugins/EasyScript/scripts/welcome.js

const PlayerJoinEvent = Java.type('org.bukkit.event.player.PlayerJoinEvent');
const PlayerQuitEvent = Java.type('org.bukkit.event.player.PlayerQuitEvent');

events.on(PlayerJoinEvent, (event) => {
    const player = event.getPlayer();
    const name = player.getName();
    
    // Using PlaceholderAPI through our integration
    const greeting = placeholder.setPlaceholders(player, "§aПривет, %player_name%! Добро пожаловать!");
    
    player.sendMessage(greeting);
    logger.info(`Игрок ${name} зашел на сервер.`);
});

events.on(PlayerQuitEvent, (event) => {
    const name = event.getPlayer().getName();
    logger.info(`Игрок ${name} покинул сервер.`);
});
