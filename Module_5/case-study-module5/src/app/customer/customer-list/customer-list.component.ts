import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../model/customer/customer";
import {CustomerType} from "../../model/customer/customer-type";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {log} from "util";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customerList: Customer[];
  customerIdDelete: number;
  customerListPaging: Customer[];
  p = 1;

  curPage = 1;
  totalPage: number;

  customerNameSearch = '';
  customerAddressSearch = '';
  customerPhoneSearch = '';

  formDelete: FormGroup = new FormGroup({
    id: new FormControl(0),
    name: new FormControl('')
  })

  constructor(private customerService: CustomerService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(value => {
      this.customerList = value;
      this.totalPage = Math.ceil(value.length / 5);
      this.customerListPaging = value.slice(0, 5);
    }, error => {

    }, () => {
      console.log("complete")
    });
  }

  getInfoCustomerDelete(customerId: number, customerName: string): void {
    this.formDelete.controls.id.setValue(customerId);
    this.formDelete.controls.name.setValue(customerName);
  }

  deleteCustomer(): void {
    this.customerIdDelete = Number(this.formDelete.value.id)
    this.customerService.deleteCustomer(this.customerIdDelete).subscribe(value => {
      alert("delete successfully");
      this.ngOnInit();
    }, error => {

    }, () => {

    })
  }
  searchByMore(): void {
    this.customerService.getAll().subscribe(value => {
      this.customerList = value.filter(item => item.customerName.toLowerCase().includes(this.customerNameSearch.toLowerCase())
        && item.customerAddress.toLowerCase().includes(this.customerAddressSearch.toLowerCase())
        && item.customerPhone.toLowerCase().includes(this.customerPhoneSearch.toLowerCase()));
      this.totalPage = Math.ceil(this.customerList.length / 5);
      this.customerListPaging = this.customerList.slice(0, 5);
    });
  }
}
