import {Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit, OnChanges, OnDestroy {
  message = '';
  remainingTime: number;
  @Input() seconds = 100;
  @Output() finish = new EventEmitter<boolean>();
  private intervalId = 0;
  v: any;

  constructor() {
  }

  ngOnInit() {
    this.reset();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if ('seconds' in changes) {
      this.v = changes.seconds.currentValue;
      this.v = typeof this.v === 'undefined' ? 100 : this.v;
      const vFixed = Number(this.v);
      this.seconds = Number.isNaN(vFixed) ? 100 : vFixed;
    }
  }

  clearTime() {
    clearInterval(this.intervalId);
  }

  ngOnDestroy() {
    this.clearTime();
  }

  private reset() {
    this.clearTime();
    this.remainingTime = this.seconds;
    this.message = 'Click start to start the countdown';
  }
  start(){
    this.countDown();
    if (this.remainingTime<=0){
      this.remainingTime = this.seconds;
    }
  }

  private countDown() {
    this.clearTime();
    this.intervalId = window.setInterval(()=>{
      this.remainingTime -=1;
      if (this.remainingTime===0){
        this.message = 'Blast off';
        this.clearTime();
        this.finish.emit(true);
      }else {
        this.message = `T-${this.remainingTime} second and counting`;
      }
    }, 1000);
  }

  stop() {
    this.clearTime();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }
}
