const { test, expect, request } = require('@playwright/test');

test.describe('getPricePerKiloByDateAndType API Tests', () => {
    let apiContext;

    test.beforeAll(async () => {
        apiContext = await request.newContext({
            baseURL: 'http://localhost:8090/api/v1',
        });
    });

    test('should return success response with price details for valid parameters', async () => {
        const response = await apiContext.get('http://localhost:8090/api/v1/pricePerKilo', {
            params: {
                effective_date: '2024-12-22',
                end_date: '2024-12-31',
                price_type: 1,
            },
        });

        // Assert HTTP status code
        expect(response.status()).toBe(200);

        // Assert response body
        const responseBody = await response.json();
        expect(responseBody.status).toBe('success');
        expect(responseBody.message).toBe('Price is Exists');
        expect(responseBody.data).toEqual({
            id: expect.any(Number),
            price_per_kilo: expect.any(Number),
            effective_date: '2024-12-22',
            end_date: '2024-12-31',
            priceType: 1,
        });

        // Additional assertions (optional)
        expect(responseBody.data.price_per_kilo).toBeGreaterThan(0);
    });

    test('should return NOT FOUND for invalid price type', async () => {
        const response = await apiContext.get('http://localhost:8090/api/v1/pricePerKilo', {
            params: {
                effective_date: '2024-12-22',
                end_date: '2024-12-31',
                price_type: 999, // Invalid price type
            },
        });

        // Assert HTTP status code
        expect(response.status()).toBe(404);

        // Assert response body
        const responseBody = await response.json();
        expect(responseBody.status).toBe('error');
        expect(responseBody.message).toBe('Price does not exist.');
        expect(responseBody.data).toBeNull();
    });

    test('should return INTERNAL SERVER ERROR for invalid date format', async () => {
        const response = await apiContext.get('http://localhost:8090/api/v1/pricePerKilo', {
            params: {
                effective_date: '01-01-2024', // Invalid date
                end_date: '2024-12-31',
                price_type: 1,
            },
        });

        // Assert HTTP status code
        expect(response.status()).toBe(500);

        // Assert response body
        const responseBody = await response.json();
        expect(responseBody.status).toBe('error');
        expect(responseBody.message).toBe('An unexpected error occurred.');
        expect(responseBody.data).toBeNull();
    });

    test('should return BAD REQUEST for missing required parameters', async () => {
        const response = await apiContext.get('http://localhost:8090/api/v1/pricePerKilo', {
            params: {
                effective_date: '2024-12-22',
                // Missing end_date and price_type
            },
        });

        // Assert HTTP status code
        expect(response.status()).toBe(400);

        // Assert response body
        const responseBody = await response.json();
        expect(responseBody.status).toBe('error');
        expect(responseBody.message).toContain('Missing required parameters');
        expect(responseBody.data).toBeNull();
    });

    test.afterAll(async () => {
        await apiContext.dispose();
    });
});
