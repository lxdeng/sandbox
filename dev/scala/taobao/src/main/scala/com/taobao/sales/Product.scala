package com.taobao.sales

class Product (_id: Int, _name: String) {

  // calls the primary constructor
  def this() = this(-1, "")

  // getter
  def id() = _id

  def name() = _name
}
