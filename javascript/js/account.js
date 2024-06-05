function Account(owner, balance, accNum) {
  this.owner = owner;
  this.balance = balance;
  this.accNum = accNum;
  this.name = "직장인 비과세 예금";
  this.bankName = "신한은행";

  this.checkBalance = () => {
    return console.log("현재잔액 : " , this.balance);
  }

  this.deposit = (balance) => {
    this.balance += balance;
  }

  this.withdraw = (balance) => {
    if(this.balance >= balance) {
      console.log(`${this.owner}계좌에서 ${balance}원을 출금합니다.`);
      this.balance -= balance;
      console.log(`출금 완료 출금 후 잔액 : ${this.balance}`);
    }
  }

  this.transfer = (user, balance) => {
    if(this.balance >= balance) {
      console.log(`${this.owner} 계좌에서 ${user.owner}에게 ${balance}원을 송금합니다.`);
      this.balance -= balance;
      user.balance += balance;
      console.log("송금 완료");
    }else {
      alert("잔액이 부족합니다.");
    }
  }
}