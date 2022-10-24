import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Route, Router} from '@angular/router';
import {Product} from '../../model/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {


  productForm: FormGroup;
  productId: number;


  constructor(private productService: ProductService,
              private activeRoute: ActivatedRoute,
              private route: Router) {
  }

  ngOnInit(): void {
    // const id = Number(this.activeRoute.snapshot.params.id);
    this.activeRoute.paramMap.subscribe(value => {
      this.productId = Number(value.get('productId'));
    });
    alert(this.productId);

    const product = this.productService.findById(this.productId);
    this.productForm = new FormGroup({
      id: new FormControl(product.id),
      name: new FormControl(product.name),
      price: new FormControl(product.price),
      description: new FormControl(product.description),
    });
  }


  updateInfoProduct(id: number) {
    const product = this.productForm.value;
    this.productService.updateProduct(id, product);
    alert('update thanh cong');
  }

}
