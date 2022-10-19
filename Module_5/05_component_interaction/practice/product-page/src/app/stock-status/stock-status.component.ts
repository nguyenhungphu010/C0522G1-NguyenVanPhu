import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-stock-status',
  templateUrl: './stock-status.component.html',
  styleUrls: ['./stock-status.component.css']
})
export class StockStatusComponent implements OnInit, OnChanges {

  @Input() stock = 0;
  @Input() productId = 0;
  @Output() stockValueChange = new EventEmitter();
  public color = '';
  public updateStockValue = 0;


  constructor() {
  }

  ngOnInit(): void {
  }

  stockValueChanged() {
    this.stockValueChange.emit({
      id: this.productId,
      updateStockValue: this.updateStockValue
    });
    this.updateStockValue = 0;
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.stock > 10) {
      this.color = 'green';
    } else {
      this.color = 'red';
    }
  }

}
