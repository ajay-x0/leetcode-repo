class Solution:
    def isPalindrome(self, s: str) -> bool:
        clean = ""

        

        for ch in s:
            if ch.isalnum():
                clean += ch.lower()

        
        
        copy_clean = clean
        clean = clean[::-1]
        if(clean == copy_clean):
            return True
        else:
            return False
