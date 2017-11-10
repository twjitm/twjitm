package com.twjitm.common.dispatcher;


public class DisPatcherEx extends  Dispatcher{

 private void reload(){
     loadPackage("com.twjitm.common.logic.chat.Impl",".class");
 }
 public void startUp(){
     reload();
 }

}
