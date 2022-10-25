import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../model/product';
import {FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {


  productForm: FormGroup;
  productId: number;
  product: Product;
  categories: Category[] = [];


  constructor(private productService: ProductService,
              private activeRoute: ActivatedRoute,
              private categoryService: CategoryService,
              private router: Router) {
  }

  ngOnInit(): void {
    // const id = Number(this.activeRoute.snapshot.params.id);
    this.activeRoute.paramMap.subscribe(value => {
      this.productId = Number(value.get('productId'));
    });
    alert(this.productId);
    this.productService.findById(this.productId).subscribe(value => {
      this.product = value;
      this.productForm.patchValue(this.product);
    });
    this.productForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      price: new FormControl(),
      description: new FormControl(),
      category: new FormControl(),
    });
    this.getAllCategory();
  }


  updateInfoProduct(): void {
    const productAfter = this.productForm.value;
    productAfter.id = this.product.id;
    this.productService.updateProduct(productAfter).subscribe(value => {

    }, error => {

    }, () => {
      alert('Update successfully');
      this.router.navigateByUrl('/product/list');
    });
  }

  getAllCategory(): void {
    this.categoryService.getAll().subscribe(value => {
      this.categories = value;
    });
  }
  compareWithId(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }
}
