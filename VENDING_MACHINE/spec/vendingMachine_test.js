describe('vending machine', function() {
  let validCoins, products, vm;
  beforeEach(function () {
    vm = new vendingMachineController();
    validCoins = [{
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
      "quantity": 0
    }, {
      "name": "chips",
      "price": "0.50",
      "quantity": 10
    }, {
      "name": "candy",
      "price": "0.65",
      "quantity": 5
    }];

  });

  it('is set up correctly', function() {
    expect(vm).toBeTruthy();
  });

  it('displays INSERT COIN when no coins are inserted', function() {
    let currentAmount = 0;
    vm.initialDisplay(currentAmount);
    expect(vm.displayMessage).toEqual('INSERT COIN');
  });

  it ('accepts nickels ', function() {
    let coinAdded = {
      "name": "nickel",
      "weight": "5.00",
      "value": "0.05",
      "quantity": 0
    };
    expect(vm.isCoinValid(coinAdded)).toBeTruthy();
  });

  it ('accepts quarters', function() {
    let coinAdded = {
      "name": "quarter",
      "weight": "5.67",
      "value": "0.25",
      "quantity": 0
    };
    expect(vm.isCoinValid(coinAdded)).toBeTruthy();
  });

  it ('accepts dimes', function() {
    let coinAdded = {
      "name": "dime",
      "weight": "2.27",
      "value": "0.10",
      "quantity": 0
    };
    expect(vm.isCoinValid(coinAdded)).toBeTruthy();
  });

  it ('does not accept pennies', function() {
    let coinAdded = {
      "name": "penny",
      "weight": "2.5",
      "value": "0.01",
      "quantity": 0
    };
    expect(vm.isCoinValid(coinAdded)).toBeFalsy();
  });

  it('displays amount in machine when coins are inserted', function() {
    let coinAdded = {
      "name": "quarter",
      "weight": "5.67",
      "value": "0.25",
      "quantity": 0}, currentAmount = 0.00;
      vm.calculateCurrentAmount(coinAdded, currentAmount);
      expect(vm.displayMessage).toEqual(0.25);
      coinAdded = {"name": "dime",
      "weight": "2.27",
      "value": "0.10",
      "quantity": 0}, currentAmount = 0.25;
      vm.calculateCurrentAmount(coinAdded, currentAmount)
      expect(vm.displayMessage).toEqual(0.35);
    });

  it ('displays "SOLD OUT" when the item selected is not available', function() {
    let selectedProduct = products[0], currentAmount = 1.00;
    vm.soldOut(selectedProduct);
    expect(vm.displayMessage).toEqual("SOLD OUT");
  });

  it ('displays amount in the machine or INSERT COIN when the item selected is not available', function() {
    let selectedProduct = products[0], currentAmount = 1.00;
    vm.soldOut(selectedProduct);
    vm.initialDisplay(currentAmount);
    expect(vm.displayMessage).toEqual(currentAmount);
    currentAmount = 0;
    vm.initialDisplay(currentAmount);
    expect(vm.displayMessage).toEqual("INSERT COIN");
  });

  it('displays THANK YOU and dispenses product when enough money has been inserted', function() {
    let selectedProduct = products[1], currentAmount = 0.50;
    vm.dispenseProducts(selectedProduct, currentAmount);
    expect(vm.displayMessage).toEqual("THANK YOU");
  });

  it('reduces inventory when product has been dispensed', function() {
    let selectedProduct = products[1], currentAmount = 0.50;
    vm.dispenseProducts(selectedProduct, currentAmount);
    expect(vm.getInventory(selectedProduct.quantity)).toEqual(9);
  });

  it('displays INSERT COIN after dispensing product', function() {
    let selectedProduct = products[1], currentAmount = 0.50;
    vm.dispenseProducts(selectedProduct, currentAmount);
    currentAmount = 0;
    vm.initialDisplay(currentAmount);
    expect(vm.displayMessage).toEqual("INSERT COIN");
  });

  it ('returns change when the amount in machine is more than the price of the selected item', function() {
    let selectedProduct = products[2], currentAmount = 1.00;
    expect(vm.makeChange(selectedProduct, currentAmount)).toEqual(0.35);
  });

  it('displays price when enough money has not been inserted', function() {
    let selectedProduct = products[1], currentAmount = 0.25;
    vm.notEnoughMoneyInserted(selectedProduct, currentAmount);
    expect(vm.displayMessage).toEqual("PRICE: " + 0.50);
  });

  it(' displays either INSERT COIN or amount in machine when enough money has not been inserted', function(){
    let selectedProduct = products[1], currentAmount = 0.25;
    vm.notEnoughMoneyInserted(selectedProduct, currentAmount);
    vm.initialDisplay(currentAmount);
    expect(vm.displayMessage).toEqual(currentAmount);
    currentAmount = 0;
    vm.initialDisplay(currentAmount);
    expect(vm.displayMessage).toEqual("INSERT COIN");
  })

  it('returns coins when "return coin" is selected and displays INSERT COIN', function() {
    let money = 0.50;
    expect(vm.returnMoney(money)).toEqual(0.50);
    currentAmount = 0;
    vm.initialDisplay(currentAmount);
    expect(vm.displayMessage).toEqual("INSERT COIN");
  });
});
