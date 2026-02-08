[16:42:35 INFO]: Areshk1n issued server command: /es reload
[16:42:35 WARN]: java.lang.NoSuchFieldException: knownCommands
[16:42:35 WARN]:        at java.base/java.lang.Class.getDeclaredField(Class.java:2782)
[16:42:35 WARN]:        at io.papermc.reflectionrewriter.runtime.AbstractDefaultRulesReflectionProxy.getDeclaredField(AbstractDefaultRulesReflectionProxy.java:90)
[16:42:35 WARN]:        at io.papermc.paper.pluginremap.reflect.PaperReflectionHolder.getDeclaredField(Unknown Source)
[16:42:35 WARN]:        at EasyScript-1.0-SNAPSHOT.jar//me.luka.easyscript.ScriptCommands.unregisterAll(ScriptCommands.java:56)
[16:42:35 WARN]:        at EasyScript-1.0-SNAPSHOT.jar//me.luka.easyscript.ScriptManager$ScriptInstance.unload(ScriptManager.java:28)
[16:42:35 WARN]:        at java.base/java.util.HashMap$Values.forEach(HashMap.java:1073)
[16:42:35 WARN]:        at EasyScript-1.0-SNAPSHOT.jar//me.luka.easyscript.ScriptManager.unloadAll(ScriptManager.java:83)
[16:42:35 WARN]:        at EasyScript-1.0-SNAPSHOT.jar//me.luka.easyscript.ScriptManager.reload(ScriptManager.java:88)
[16:42:35 WARN]:        at EasyScript-1.0-SNAPSHOT.jar//me.luka.easyscript.CommandHandler.onCommand(CommandHandler.java:25)
[16:42:35 WARN]:        at org.bukkit.command.PluginCommand.execute(PluginCommand.java:45)
[16:42:35 WARN]:        at io.papermc.paper.command.brigadier.bukkit.BukkitCommandNode$BukkitBrigCommand.run(BukkitCommandNode.java:82)
[16:42:35 WARN]:        at com.mojang.brigadier.context.ContextChain.runExecutable(ContextChain.java:73)
[16:42:35 WARN]:        at net.minecraft.commands.execution.tasks.ExecuteCommand.execute(ExecuteCommand.java:30)
[16:42:35 WARN]:        at net.minecraft.commands.execution.tasks.ExecuteCommand.execute(ExecuteCommand.java:13)
[16:42:35 WARN]:        at net.minecraft.commands.execution.UnboundEntryAction.lambda$bind$0(UnboundEntryAction.java:8)
[16:42:35 WARN]:        at net.minecraft.commands.execution.CommandQueueEntry.execute(CommandQueueEntry.java:5)
[16:42:35 WARN]:        at net.minecraft.commands.execution.ExecutionContext.runCommandQueue(ExecutionContext.java:105)
[16:42:35 WARN]:        at net.minecraft.commands.Commands.executeCommandInContext(Commands.java:435)
[16:42:35 WARN]:        at net.minecraft.commands.Commands.performCommand(Commands.java:342)
[16:42:35 WARN]:        at net.minecraft.commands.Commands.performCommand(Commands.java:332)
[16:42:35 WARN]:        at net.minecraft.commands.Commands.performCommand(Commands.java:326)
[16:42:35 WARN]:        at net.minecraft.server.network.ServerGamePacketListenerImpl.performUnsignedChatCommand(ServerGamePacketListenerImpl.java:2204)
[16:42:35 WARN]:        at net.minecraft.server.network.ServerGamePacketListenerImpl.lambda$handleChatCommand$11(ServerGamePacketListenerImpl.java:2177)
[16:42:35 WARN]:        at net.minecraft.server.TickTask.run(TickTask.java:18)
[16:42:35 WARN]:        at net.minecraft.util.thread.BlockableEventLoop.doRunTask(BlockableEventLoop.java:155)
[16:42:35 WARN]:        at net.minecraft.util.thread.ReentrantBlockableEventLoop.doRunTask(ReentrantBlockableEventLoop.java:24)
[16:42:35 WARN]:        at net.minecraft.server.MinecraftServer.doRunTask(MinecraftServer.java:1448)
[16:42:35 WARN]:        at net.minecraft.server.MinecraftServer.doRunTask(MinecraftServer.java:176)
[16:42:35 WARN]:        at net.minecraft.util.thread.BlockableEventLoop.pollTask(BlockableEventLoop.java:129)
[16:42:35 WARN]:        at net.minecraft.server.MinecraftServer.pollTaskInternal(MinecraftServer.java:1428)
[16:42:35 WARN]:        at net.minecraft.server.MinecraftServer.pollTask(MinecraftServer.java:1422)
[16:42:35 WARN]:        at net.minecraft.util.thread.BlockableEventLoop.managedBlock(BlockableEventLoop.java:139)
[16:42:35 WARN]:        at net.minecraft.server.MinecraftServer.managedBlock(MinecraftServer.java:1379)
[16:42:35 WARN]:        at net.minecraft.server.MinecraftServer.waitUntilNextTick(MinecraftServer.java:1387)
[16:42:35 WARN]:        at net.minecraft.server.MinecraftServer.runServer(MinecraftServer.java:1264)
[16:42:35 WARN]:        at net.minecraft.server.MinecraftServer.lambda$spin$2(MinecraftServer.java:310)
[16:42:35 WARN]:        at java.base/java.lang.Thread.run(Thread.java:1583)
[16:42:35 INFO]: [EasyScript] Loaded script: border_logic.js
[16:42:44 INFO]: Areshk1n issued server command: /ws home
[16:42:44 INFO]: Preparing start region for dimension minecraft:id20-3ed82293-7e0e-4047-882a-05a4eee1a0a1
[16:42:44 INFO]: Time elapsed: 1 ms
[16:43:12 INFO]: Areshk1n issued server command: /upgrade-border
[16:43:12 ERROR]: Command exception: /upgrade-border
java.lang.IllegalStateException: The Context is already closed.
        at EasyScript-1.0-SNAPSHOT.jar/com.oracle.truffle.polyglot.PolyglotEngineException.closedException(PolyglotEngineException.java:139) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/com.oracle.truffle.polyglot.PolyglotContextImpl.checkClosedOrDisposing(PolyglotContextImpl.java:1268) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/com.oracle.truffle.polyglot.PolyglotContextImpl.enterThreadChanged(PolyglotContextImpl.java:819) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/com.oracle.truffle.polyglot.PolyglotEngineImpl.enterCached(PolyglotEngineImpl.java:2033) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/com.oracle.truffle.polyglot.HostToGuestRootNode.execute(HostToGuestRootNode.java:109) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/com.oracle.truffle.api.impl.DefaultCallTarget.callDirectOrIndirect(DefaultCallTarget.java:85) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/com.oracle.truffle.api.impl.DefaultCallTarget.call(DefaultCallTarget.java:102) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/com.oracle.truffle.api.impl.DefaultRuntimeAccessor$DefaultRuntimeSupport.callProfiled(DefaultRuntimeAccessor.java:182) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/com.oracle.truffle.polyglot.PolyglotValueDispatch$InteropValue.execute(PolyglotValueDispatch.java:2452) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/org.graalvm.polyglot.Value.execute(Value.java:881) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at EasyScript-1.0-SNAPSHOT.jar/me.luka.easyscript.ScriptCommands$1.execute(ScriptCommands.java:41) ~[EasyScript-1.0-SNAPSHOT.jar:?]
        at io.papermc.paper.command.brigadier.bukkit.BukkitCommandNode$BukkitBrigCommand.run(BukkitCommandNode.java:82) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at com.mojang.brigadier.context.ContextChain.runExecutable(ContextChain.java:73) ~[brigadier-1.3.10.jar:?]
        at net.minecraft.commands.execution.tasks.ExecuteCommand.execute(ExecuteCommand.java:30) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.commands.execution.tasks.ExecuteCommand.execute(ExecuteCommand.java:13) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.commands.execution.UnboundEntryAction.lambda$bind$0(UnboundEntryAction.java:8) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.commands.execution.CommandQueueEntry.execute(CommandQueueEntry.java:5) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.commands.execution.ExecutionContext.runCommandQueue(ExecutionContext.java:105) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.commands.Commands.executeCommandInContext(Commands.java:435) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.commands.Commands.performCommand(Commands.java:342) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.commands.Commands.performCommand(Commands.java:332) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.commands.Commands.performCommand(Commands.java:326) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.network.ServerGamePacketListenerImpl.performUnsignedChatCommand(ServerGamePacketListenerImpl.java:2204) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.network.ServerGamePacketListenerImpl.lambda$handleChatCommand$11(ServerGamePacketListenerImpl.java:2177) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.TickTask.run(TickTask.java:18) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.util.thread.BlockableEventLoop.doRunTask(BlockableEventLoop.java:155) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.util.thread.ReentrantBlockableEventLoop.doRunTask(ReentrantBlockableEventLoop.java:24) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.MinecraftServer.doRunTask(MinecraftServer.java:1448) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.MinecraftServer.doRunTask(MinecraftServer.java:176) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.util.thread.BlockableEventLoop.pollTask(BlockableEventLoop.java:129) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.MinecraftServer.pollTaskInternal(MinecraftServer.java:1428) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.MinecraftServer.pollTask(MinecraftServer.java:1422) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.util.thread.BlockableEventLoop.runAllTasks(BlockableEventLoop.java:118) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.MinecraftServer.tickServer(MinecraftServer.java:1561) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.MinecraftServer.runServer(MinecraftServer.java:1251) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at net.minecraft.server.MinecraftServer.lambda$spin$2(MinecraftServer.java:310) ~[paper-1.21.4.jar:1.21.4-136-e0711af]
        at java.base/java.lang.Thread.run(Thread.java:1583) ~[?:?]
        Suppressed: com.oracle.truffle.api.TruffleStackTrace$LazyStackTrace
