//
//  UserBallTest.swift
//  iOSbaseballTests
//
//  Created by KimMinSeok on 5/21/24.
//

import XCTest
@testable import iOSbaseball

final class UserBallTest: XCTestCase {

    func test_숫자를_받아서_확인할_수_있다() throws{
        // Given
        let UserNumbers = [3,2,4]
        
        // Given
        let UserBall = try UserBall(numbers: UserNumbers).numbers
        
        // Then
        XCTAssertEqual(UserBall, [3,2,4])
    }
    
    func test_숫자를_받아서_확인할_수_있다2() throws{
        // Given
        let UserNumbers = [3,2,9]
        
        // Given
        let UserBall = try UserBall(numbers: UserNumbers).numbers
        
        // Then
        XCTAssertEqual(UserBall, [3,2,9])
    }
  
    func test_3자리의_수가_들어와야_한다() throws {
        // Given
        let numbers = [1, 2, 3, 4]
        
        // Then
        XCTAssertThrowsError(try UserBall(numbers: numbers))
    }
    
    func test_숫자는_같은_수가_입력되면_안된다() throws {
        // Given
        let numbers = [3, 3, 1]
        
        // Then
        XCTAssertThrowsError(try UserBall(numbers: numbers))
    }
    
    func test_숫자는_0은_불가능하다() throws {
        // Given
        let numbers = [3, 2, 0]
        
        // Then
        XCTAssertThrowsError(try UserBall(numbers: numbers))
    }

    func test_숫자는_1에서_9까지의_숫자만_가능하다() throws {
        // Given
        let numbers = [1233, 2, 0]
        
        // Then
        XCTAssertThrowsError(try UserBall(numbers: numbers))
    }
    
    func test_숫자는_1에서_9까지의_숫자만_가능하다2() throws {
        // Given
        let numbers = [1233, 2, 5]
        
        // Then
        XCTAssertThrowsError(try UserBall(numbers: numbers))
    }
}
