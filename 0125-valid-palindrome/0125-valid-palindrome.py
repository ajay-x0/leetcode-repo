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


'''
we used isalnum() --> it wil return true for characters that are alphabets and return false for digits (0-9) and special ascii characters

clean[::-1] --> reverse the string by slicing

if clean (reversed string) == copy_clean (original string with no non alphabet chars)
return True
else --> return False

'''