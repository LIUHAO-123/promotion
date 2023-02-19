package com.bishe.promotion.component;



import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class PreDestory {

  @PreDestroy
  public void exitApp() {

  }

}
