//
//  RefereeTest.swift
//  iOSbaseballTests
//
//  Created by KimMinSeok on 5/21/24.
//

import XCTest
@testable import iOSbaseball

final class RefereeTest: XCTestCase {

    func test_Referee는_볼을_출력한다(){
        // Given
        let number1 = [1,2,3]
        let number2 = [3,4,5]
        
        // When
        let actual = Referee().getGameScore(baseNumbers: number1, targetNumbers: number2)
        
        // Then
        XCTAssertEqual(actual, Score(ball: 1, strike: 0))
    }
    
    func test_스트라이크를_출력한다(){
        // Given
        let number1 = [1,2,3]
        let number2 = [1,2,5]
        
        // When
        let actual = Referee().getGameScore(baseNumbers: number1, targetNumbers: number2)
        
        // Then
        XCTAssertEqual(actual, Score(ball: 0, strike: 2))
    }
    
    func test_올바른_경기_결과를_출력한다(){
        // Given
        let number1 = [1,2,3]
        let number2 = [1,3,2]
        
        // When
        let actual = Referee().getGameScore(baseNumbers: number1, targetNumbers: number2)
        
        // Then
        XCTAssertEqual(actual, Score(ball: 2, strike: 1))
    }

}
