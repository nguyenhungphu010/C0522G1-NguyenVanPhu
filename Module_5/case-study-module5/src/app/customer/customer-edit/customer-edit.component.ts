import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Customer} from "../../model/customer/customer";
import {CustomerType} from "../../model/customer/customer-type";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerForm: FormGroup;
  customerId: number;
  customer: Customer;
  typeList: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              private activeRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(value => {
      this.customerId = Number(value.get('id'));
    });
    alert(this.customerId);
    this.customerService.findById(this.customerId).subscribe(value => {
      this.customer = value;
      this.customerForm.patchValue(this.customer);
    })
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
    })
    this.getAllType();
    console.log(this.customer)
  }

  getAllType(): void {
    this.customerService.getAllCustomerType().subscribe(value => {
      this.typeList = value;
    })
  }

  updateCustomer(): void {
    const customerAfter = this.customerForm.value;
    customerAfter.id = this.customer.id;
    this.customerService.updateCustomer(customerAfter).subscribe(value => {

    }, error => {

    }, () => {
      alert("update successfully");
      this.router.navigateByUrl('customer/list');
    })


  }

  compareWithId(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }
}
