package me.simple.Lobby;

import me.simple.Lobby.Board.Scoreboarding;
import me.simple.Lobby.api.ChatF;
import me.simple.Lobby.api.Evento;
import me.simple.Lobby.cmd.Fly;
import me.simple.Lobby.cmd.Tag;
import me.simple.Lobby.gui.ConfiG;
import me.simple.Lobby.gui.GadgetsG;
import me.simple.Lobby.gui.serversG;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  public static String prefix;
  public static String prefix2;
  public static String cor2;
  public static String FullPvP_Name;
  public static String KitPvP_Name;
  public static String Hg_Name;
  public static String novidade;
  public static String motd;
  public static String site;
  public static String Msg_Entrar1;
  public static String Msg_Entrar2;
  public static String Msg_Entrar3;
  public static String Score_Name;
  public static String Stats_Kitpvp;
  public static String Stats_Hg;
  public static String Stats_FullPvP;
  public static String Ip_Da_Score;
  public static String connect;
  public static Plugin plugin;
  public static Main instance;
  public static String cor;
public static String semperm;
  private FileConfiguration config;
  
  public void onEnable()
  {
	  
    plugin = this;
    instance = this;
    RegisterEvents();
    Comandos();
    saveDefaultConfig();
    this.config = getConfig();
    prefix = this.config.getString("Prefix").replace("{default}", "§eLobby").replace("&", "§").replace("{setinha}", "§");
    cor = this.config.getString("Cor").replace("{default}", "§6").replace("&", "§").replace("{setinha}", "§");
    cor2 = this.config.getString("Cor2").replace("{default}", "§e").replace("&", "§").replace("{setinha}", "§");
    semperm = this.config.getString("Sem_Permissao").replace("{default}", "§6").replace("&", "§").replace("{setinha}", "§");
    connect = this.config.getString("Conectado").replace("{default}", "&eLobby").replace("&", "§").replace("{setinha}", "§");
    novidade = this.config.getString("Novidade").replace("{default}", "&eFullPvP").replace("&", "§").replace("{setinha}", "§");
    Ip_Da_Score = this.config.getString("Ip_Da_Score").replace("{default}", "&7mc.berilox.com").replace("&", "§").replace("{setinha}", "§");
    Score_Name = this.config.getString("Nome_Da_Score").replace("{default}", "&6&lBerilox&f&lNetwork").replace("&", "§").replace("{setinha}", "§");
    KitPvP_Name = this.config.getString("KitPvP_Name").replace("{default}", cor + "Berilox" + cor2 + "PvP").replace("&", "§").replace("{setinha}", "§");
    Hg_Name = this.config.getString("Hg_Name").replace("{default}", cor + "Berilox" + cor2 + "HG").replace("&", "§").replace("{setinha}", "§");
    FullPvP_Name = this.config.getString("FullPvP_Name").replace("{default}", cor + "Berilox" + cor2 + "FullPvP").replace("&", "§").replace("{setinha}", "§");
    prefix2 = this.config.getString("Prefix2").replace("{default}", "§eMC-TWORK").replace("&", "§").replace("{setinha}", "§");
    site = this.config.getString("Site").replace("{default}", "§www.mctwork.tk").replace("&", "§").replace("{setinha}", "§");
    Msg_Entrar1 = this.config.getString("Msg_Entrar1").replace("{default}", "&f Bem vindo ao servidor &6&lBerilox&f&lNetwork").replace("&", "§").replace("{setinha}", "§");
    Msg_Entrar2 = this.config.getString("Msg_Entrar2").replace("{default}", "&f Seridor est§ na vers§o 2.0").replace("&", "§").replace("{setinha}", "§");
    Msg_Entrar3 = this.config.getString("Msg_Entrar3").replace("{default}", "&f Voce se conectou ao: &aLOBBY&f.").replace("&", "§").replace("{setinha}", "§");
    Stats_Kitpvp = this.config.getString("Stats_KitPvP").replace("{default}", "&aON").replace("&", "§").replace("{setinha}", "§");
    Stats_Hg = this.config.getString("Stats_Hg").replace("{default}", "&aON").replace("&", "§").replace("{setinha}", "§");
    Stats_FullPvP = this.config.getString("Stats_FullPvP").replace("{default}", "&aON").replace("&", "§").replace("{setinha}", "§");
    motd = this.config.getString("Motd").replace("{default}", "&6&lBerilox&f&lNetwork &6{setinha} &7 Agora disponivel varios modos de jogo!").replace("&", "§").replace("{setinha}", "§");
    Bukkit.getConsoleSender().sendMessage(Main.prefix + "§7 Plugin ativado com sucesso!");
    Bukkit.getConsoleSender().sendMessage(Main.prefix + "§7 Plugin desenvolvido por HypeerDev");
    Bukkit.getConsoleSender().sendMessage(Main.prefix + "§7 Este plugin não foi decompilado! no cry :)");
  }
  
  public void onDisable()
  {
    Bukkit.getConsoleSender().sendMessage(Main.prefix + "§7 Plugin desativado com sucesso!");
    Bukkit.getConsoleSender().sendMessage(Main.prefix + "§7 Plugin desenvolvido por HypeerDev");
    Bukkit.getConsoleSender().sendMessage(Main.prefix + "§7 Este plugin nao foi decompilado! no cry :)");
  }
  
  public static Main getIntance()
  {
    return instance;
  }
  
  public static Plugin getPlugin()
  {
    return plugin;
  }
  
  public void RegisterEvents()
  {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new Evento(), this);
    pm.registerEvents(new GadgetsG(), this);
    pm.registerEvents(new serversG(), this);
    pm.registerEvents(new ConfiG(), this);
    pm.registerEvents(new Scoreboarding(), this);
    pm.registerEvents(new ChatF(), this);
  }
  
  public void Comandos()
  {
    getCommand("fly").setExecutor(new Fly());
    getCommand("tag").setExecutor(new Tag());
  }
}