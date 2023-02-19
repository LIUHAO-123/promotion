package com.bishe.promotion.services;

import com.bishe.promotion.entities.Address;
import com.bishe.promotion.entities.User;
import com.bishe.promotion.repositories.IAddressRepository;
import com.bishe.promotion.repositories.IUserRepository;
import com.bishe.promotion.utils.Md5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class
AddressServiceImpl implements IAddressService {

  Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

  @Autowired
  IAddressRepository  addressRepository;
  @Override
  public int save(Address address) {
    addressRepository.save(address);//把Address信息保存到数据库

    return address.getId();
  }
}
