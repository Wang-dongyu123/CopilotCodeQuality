/**https://leetcode.com/problems/reveal-cards-in-increasing-order/ */
//You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].
//You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
//You will do the following steps repeatedly until all cards are revealed:
//Take the top card of the deck, reveal it, and take it out of the deck.
//If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
//If there are still unrevealed cards, go back to step 1. Otherwise, stop.
//Return an ordering of the deck that would reveal the cards in increasing order.
//Note that the first entry in the answer is considered to be the top of the deck.


/**
 * @param {number[]} deck
 * @return {number[]}
 */
var deckRevealedIncreasing = function(deck) {
    deck.sort((a, b) => a - b);
    let result = new Array(deck.length).fill(0);
    let index = new Array(deck.length).fill(0);
    for(let i = 0; i < deck.length; i++){
        index[i] = i;
    }
    let i = 0;
    while(index.length > 0){
        result[index.shift()] = deck[i];
        if(index.length > 0){
            index.push(index.shift());
        }
        i++;
    }
    return result;
    
};

    