"use strict";
function vendingMachineController() {

  this.isCoinValid = isCoinValid;
  this.makeChange = makeChange;
  this.soldOut = soldOut;
  this.calculateCurrentAmount = calculateCurrentAmount;
  this.initialDisplay = initialDisplay;
  this.returnMoney = returnMoney;
  this.dispenseProducts = dispenseProducts;
  this.notEnoughMoneyInserted = notEnoughMoneyInserted;
  this.getInventory = getInventory;

  this.displayMessage  = "INSERT COIN";

  var validCoins = [{
    "name": "nickel",
    "weight": "5.00",
    "value": "0.05",
    "quantity": 0
  }, {
    "name": "dime",
    "weight": "2.27",
    "value": "0.10",
    "quantity": 0
  }, {
    "name": "quarter",
    "weight": "5.67",
    "value": "0.25",
    "quantity": 0
  }],
  products = [{
    "name": "cola",
    "price": "1.00",
    "quantity": 10
  }, {
    "name": "chips",
    "price": "0.50",
    "quantity": 10
  }, {
    "name": "candy",
    "price": "0.65",
    "quantity": 10
  }],
  coinAdded = {},
  selectedProduct = {},
  currentAmount = 0;

  function initialDisplay(currentAmount) {
    if (currentAmount === 0) {
      this.displayMessage = "INSERT COIN";
    }
    else{
      this.displayMessage = currentAmount;
    }
  }

  function isCoinValid(coinAdded) {
    for (var i = 0; i < validCoins.length; i++) {
      if (validCoins[i].weight === coinAdded.weight) {
        return true;
      }
    }
    return false;
  }

  function calculateCurrentAmount(coinAdded, currentAmount) {
    if (isCoinValid(coinAdded)) {
      currentAmount = currentAmount + parseFloat(coinAdded.value);
      this.displayMessage = currentAmount;
    } else {
      return rejectMoney(coinAdded);
    }
  }

  function makeChange(selectedProduct, currentAmount) {
    if (selectedProduct.price < currentAmount) {
      return returnMoney(currentAmount - parseFloat(selectedProduct.price), currentAmount);
    }
    else return 0;
  }

  function returnMoney(money, currentAmount) {
    currentAmount = 0;
    return money;
  }

  function soldOut(selectedProduct) {
    if (selectedProduct.quantity === 0) {
      this.displayMessage = "SOLD OUT";
    }
  }

  function rejectMoney(coinAdded) {
    coinAdded = {};
    return coinAdded;
  }

  function dispenseProducts(selectedProduct, currentAmount) {
    if (currentAmount == parseFloat(selectedProduct.price)){
      selectedProduct.quantity = selectedProduct.quantity - 1;
      getInventory(selectedProduct.quantity);
      currentAmount = 0;
      this.displayMessage="THANK YOU";
    }
  }

  function getInventory(qtty) {
    return qtty;
  }

  function notEnoughMoneyInserted(selectedProduct, currentAmount) {
    if (0 < currentAmount && currentAmount < parseFloat(selectedProduct.price)){
      this.displayMessage = "PRICE: "+ parseFloat(selectedProduct.price);
    }
  }
}
