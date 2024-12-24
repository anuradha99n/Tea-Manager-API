// tests/savePricePerKilo.spec.js
const { test, expect } = require('@playwright/test');

test.describe('Save PricePerKilo API', () => {
    test('should validate and save pricePerKilo with valid data', async ({ request }) => {
        // Arrange: Prepare valid payload
        const payload = {
            price_per_kilo: 100.50,
            priceType: 1, // Corresponds to EMPLOYEE
            effective_date: '2024-12-22',
            end_date: '2024-12-31'
        };

        // Act: Send API request
        const response = await request.post('http://localhost:8090/api/v1/pricePerKilo', {
            data: payload,
        });

        // Assert: Validate the response
        expect(response.status()).toBe(200); // Assuming success status is 200
        const responseBody = await response.json();
        expect(responseBody).toMatchObject({
            status: 'success',
            message: 'PricePerKilo saved successfully',
            data: {
                id: expect.any(Number), // Dynamically generated id
                price_per_kilo: 100.50,
                priceType: 1,
                effective_date: '2024-12-22',
                end_date: '2024-12-31'
            }
        });
    });

    test('should return error for invalid price_per_kilo', async ({ request }) => {
        // Arrange: Prepare invalid payload
        const payload = {
            price_per_kilo: -10, // Invalid value
            priceType: 1, // EMPLOYEE
            effective_date: '2024-12-22',
            end_date: '2024-12-31'
        };

        // Act: Send API request
        const response = await request.post('http://localhost:8090/api/v1/pricePerKilo', {
            data: payload,
        });

        // Assert: Validate the response
        expect(response.status()).toBe(400); // Assuming validation errors return 400
        const responseBody = await response.json();
        expect(responseBody).toMatchObject({
            message: 'The price_per_kilo must be a positive value.'
        });
    });

    test('should return error for invalid priceType', async ({ request }) => {
        // Arrange: Prepare invalid payload
        const payload = {
            price_per_kilo: 100.50,
            priceType: 999, // Invalid value not in enum
            effective_date: '2024-12-22',
            end_date: '2024-12-31'
        };

        // Act: Send API request
        const response = await request.post('http://localhost:8090/api/v1/pricePerKilo', {
            data: payload,
        });

        // Assert: Validate the response
        expect(response.status()).toBe(400); // Assuming validation errors return 400
        const responseBody = await response.json();
        expect(responseBody).toMatchObject({
            message: 'Invalid priceType. Must be one of: [1, 2]'
        });
    });
});
