import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Customer} from "../../model/customer/customer";
import {CustomerType} from "../../model/customer/customer-type";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {
  customer: Customer;
  customerType: CustomerType[] = [];
  customerForm: FormGroup;

  constructor(private customerService: CustomerService,
              private activeRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllType();
    this.customerForm = new FormGroup({
      id: new FormControl(),
      customerName: new FormControl(),
      customerEmail: new FormControl(),
      customerPhone: new FormControl(),
      customerAddress: new FormControl(),
      customerType: new FormControl(),
      customerBirthday: new FormControl(),
      customerGender: new FormControl(),
      customerIdCard: new FormControl(),
    });
  }

  createCustomer(): void {
    this.customer = this.customerForm.value;
    this.customerService.saveCustomer(this.customer).subscribe(value => {

    }, error => {

    }, () => {
      alert('Add successfully!');
      this.router.navigateByUrl('/customer/list');
    })
  }

  getAllType(): void {
    this.customerService.getAllCustomerType().subscribe(value => {
      this.customerType = value;
    })
  }

}
