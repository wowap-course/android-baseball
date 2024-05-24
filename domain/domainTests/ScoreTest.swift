//
//  ScoreTest.swift
//  iOSbaseballTests
//
//  Created by KimMinSeok on 5/21/24.
//

import XCTest
@testable import domain

final class ScoreTest: XCTestCase {

    func test_점수는_입력한_스트라이크와_볼의_데이터를_가진다(){
        // Given
        let ball = 2
        let strike = 1
        
        // When
        let actual = Score(ball: ball, strike: strike)
                
        // Then
        XCTAssertEqual(actual, Score(ball: 2, strike: 1))
    }

}
