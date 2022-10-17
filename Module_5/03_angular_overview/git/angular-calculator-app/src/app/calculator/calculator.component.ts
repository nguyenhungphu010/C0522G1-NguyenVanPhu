import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  number1: number;
  number2: number;

  resultSum: number;
  resultMinus: number;
  resultTimes: number;
  resultDivide: number;

  constructor() { }

  ngOnInit(): void {
  }

  sum2Num(): void{
    this.resultSum = Number(this.number1) + Number(this.number2);
  }
  minus2Num():void{
    this.resultMinus = Number(this.number1) - Number(this.number2);
  }

  times2Num():void{
    this.resultTimes = Number(this.number1) * Number(this.number2);
  }

  divide2Num():void{
    this.resultDivide = Number(this.number1) / Number(this.number2);
  }

}
