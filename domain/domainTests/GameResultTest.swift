//
//  GameResultTest.swift
//  domainTests
//
//  Created by KimMinSeok on 5/28/24.
//

import XCTest
@testable import domain

final class GameResultTest: XCTestCase {

    func test_각_결과에_맞는_데이터를_저장한다1(){
        // Given
        let ball = 2
        let strike = 1
        
        // When
        let actual = Score(ball: ball, strike: strike)
                
        // Then
        XCTAssertEqual(actual, Score(ball: 2, strike: 1))
    }

}
