import { HttpService } from '@nestjs/axios';
import { Injectable } from '@nestjs/common';
import { ConfigService } from '@nestjs/config';
import { BaseApiService } from 'src/common/services/base-api.service';

@Injectable()
export class CatalogService extends BaseApiService{
      constructor(httpService: HttpService, configService: ConfigService) {
            super(httpService, configService, 'PRODUCT_SERVICE_URL');
        }

 async createProduct(product: {
        name: string;
        description: string;
        price: number;
        imageUrl: string;
        categoryId: number;
        status: boolean;
        stockQuantity: number;
    }) {
        const request$ = this.httpService.post(
            `${this.serviceUrl}/api/products`,
            product,
            {
                headers: { 'Content-Type': 'application/json' },
            }
        );

        return this.makeRequest(request$);
    }
    async updateProduct(
        id: number,
        product: {
            name: string;
            description: string;
            price: number;
            imageUrl: string;
            categoryId: number;
            status: boolean;
            stockQuantity: number;
        }
    ) {
        const request$ = this.httpService.put(
            `${this.serviceUrl}/api/products/${id}`,
            product,
            {
                headers: { 'Content-Type': 'application/json' },
            }
        );

        return this.makeRequest(request$);
    }
       async updateProductStock(id: number, stockQuantity: number) {
        const request$ = this.httpService.put(
            `${this.serviceUrl}/api/products/${id}/stock`,
            { stockQuantity },
            {
                headers: { 'Content-Type': 'application/json' },
            }
        );

        return this.makeRequest(request$);
    }

     async getProduct(id: number) {
        const request$ = this.httpService.get(
            `${this.serviceUrl}/api/products/${id}`
        );

        return this.makeRequest(request$);
    }
     async getAllProducts() {
        const request$ = this.httpService.get(
            `${this.serviceUrl}/api/products`
        );

        return this.makeRequest(request$);
    }

     async getAllCategories() {
        const request$ = this.httpService.get(
            `${this.serviceUrl}/api/categories`
        );

        return this.makeRequest(request$);
    }
}
