//
//  iOSbaseballTests.swift
//  iOSbaseballTests
//
//  Created by KimMinSeok on 5/18/24.
//

import XCTest
@testable import domain

final class iOSbaseballTests: XCTestCase {
    
    func test_처음_목숨의_개수는_1개이다() throws {
        let lifeCount = try LifeCount().lifes
        
        XCTAssertEqual(lifeCount, 1)
    }
    
    func test_목숨은_1에서_20_사이의_숫자이다() throws {
        // Given
        let lifes = 21
        
        // Then
        XCTAssertThrowsError(try LifeCount(lifes: lifes))
    }
    
    func test_목숨은_1에서_10_사이의_숫자이다2() throws {
        // Given
        let lifes = 0
        
        // Then
        XCTAssertThrowsError(try LifeCount(lifes: lifes))
    }
    
    func test_목숨을_추가할_수_있다() throws {
        // Given
        let lifeCount = try LifeCount()
        
        // When
        let result = lifeCount.increase()
        
        // Then
        XCTAssertTrue(result)
        XCTAssertEqual(lifeCount.lifes, 2)
    }
    
    func test_목숨을_뺄_수_있다() throws {
        // Given
        let lifeCount = try LifeCount(lifes: 2)
        
        // When
        let result = lifeCount.decrease()
        
        // Then
        XCTAssertTrue(result)
        XCTAssertEqual(lifeCount.lifes, 1)
    }
    
    func test_20개의_목숨에서_추가는_되지_않는다() throws {
        // Given
        let lifeCount = try LifeCount(lifes: 20)
        
        // When
        let result = lifeCount.increase()
        
        // Then
        XCTAssertFalse(result)
        XCTAssertEqual(lifeCount.lifes, 20)
        XCTAssertNotEqual(lifeCount.lifes, 21)
    }
    
    func test_1개의_목숨에서_빼지지_않는다() throws {
        // Given
        let lifeCount = try LifeCount(lifes: 1)
        
        // When
        let result = lifeCount.decrease()
        
        // Then
        XCTAssertFalse(result)
        XCTAssertEqual(lifeCount.lifes, 1)
        XCTAssertNotEqual(lifeCount.lifes, 0)
    }
    
}
