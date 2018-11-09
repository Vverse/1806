package com.xbcake.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbcake.common.po.Cart;
import com.xbcake.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public Cart findCartById(Long id) {
		return cartMapper.selectByPrimaryKey(id);
	}

}
