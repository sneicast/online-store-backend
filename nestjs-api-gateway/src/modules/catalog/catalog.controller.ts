import { Body, Controller, Get, HttpCode, HttpStatus, Param, Put, Post } from '@nestjs/common';
import { CatalogService } from './catalog.service';

@Controller()
export class CatalogController {
  constructor(private readonly catalogService: CatalogService) {}

   @Get('/categories')
    @HttpCode(HttpStatus.OK)
    async getAllCategories() {
        return this.catalogService.getAllCategories();
    }

  @Post('products')
  @HttpCode(HttpStatus.CREATED)
  async createProduct(@Body() body: any) {
    return this.catalogService.createProduct(body);
  }

  @Put('products/:id')
  @HttpCode(HttpStatus.OK)
  async updateProduct(@Param('id') id: number, @Body() body: any) {
    return this.catalogService.updateProduct(Number(id), body);
  }

  @Put('products/:id/stock')
  @HttpCode(HttpStatus.OK)
  async updateProductStock(@Param('id') id: number, @Body('stockQuantity') stockQuantity: number) {
    return this.catalogService.updateProductStock(Number(id), stockQuantity);
  }

  @Get('products/:id')
  @HttpCode(HttpStatus.OK)
  async getProduct(@Param('id') id: number) {
    return this.catalogService.getProduct(Number(id));
  }

  @Get('products')
  @HttpCode(HttpStatus.OK)
  async getAllProducts() {
    return this.catalogService.getAllProducts();
  }
}
