import { Body, Controller, HttpCode, HttpStatus, Post } from '@nestjs/common';
import { AuthService } from './auth.service';

@Controller('auth')
export class AuthController {
  constructor(private readonly authService: AuthService) { }
  
  @Post('admin/login')
  @HttpCode(HttpStatus.OK)
  async loginAdmin(@Body() body: { username: string; password: string }) {
    return this.authService.loginAdmin(body);
  }
  @Post('customer/login')
  @HttpCode(HttpStatus.OK)
  async loginCustomer(@Body() body: { username: string; password: string }) {
    return this.authService.loginCustomer(body);
  }
}
