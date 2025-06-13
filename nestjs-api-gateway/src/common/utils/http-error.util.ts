import { HttpException } from '@nestjs/common';

export class HttpErrorUtil {
  static handleApiError(error: any): never {
    const status = error?.response?.status || 500;
    const responseBody = error?.response?.data || { message: 'Unknown error' };
    throw new HttpException(responseBody, status);
  }
}